package com.delta.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.delta.mybaits.model.sysUser.SysUserModel;
import com.delta.service.user.SysUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShiroRealm extends AuthorizingRealm{
	
	@Autowired
	private SysUserService userService;
	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("doGetAuthorizationInfo+"+principalCollection.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

//        User user = userService.getByUserName((String) principalCollection.getPrimaryPrincipal());
//
//
//        //把principals放session中 key=userId value=principals
//        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()),SecurityUtils.getSubject().getPrincipals());
//
//        
//        //赋予角色
//        for(Role userRole:user.getRoles()){
//            info.addRole(userRole.getName());
//        }
//        //赋予权限
//        for(Permission permission:permissionService.getByUserId(user.getId())){
////            if(StringUtils.isNotBlank(permission.getPermCode()))
//                info.addStringPermission(permission.getName());
//        }

        //设置登录次数、时间
//        userService.updateUserLogin(user);
        return info;
    }

	/**
	 * 用户认证 -- 从login controller 中载入
	 */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    	log.info("doGetAuthenticationInfo +"  + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.copyValueOf(token.getPassword());
        SysUserModel user = new SysUserModel();
		user.setUsername(username);
		user.setPassword(password);
		SysUserModel newUser = userService.findOneUser(user);
	    if (newUser == null) {
		      throw new UnknownAccountException();
        }
        
		return new SimpleAuthenticationInfo(user, password, getName());
    }

}
