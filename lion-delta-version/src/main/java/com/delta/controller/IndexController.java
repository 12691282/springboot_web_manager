package com.delta.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.delta.base.BaseController;
import com.delta.mybaits.model.sysUser.SysUserModel;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController extends BaseController{
	
	@RequestMapping("login")
	public String login(){
	    return "login";
	}
	
	@RequestMapping(value ="toLogin")
	public String toLogin(Model model,  String username, String password){
		if(username == null || password == null){
			return "login"; 
		}
		
		 UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
		// 获取主体
		Subject subject = SecurityUtils.getSubject();
		try{
	        //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
		    subject.login(token);
		} catch(UnknownAccountException uae){  
	        model.addAttribute("loginInfo", "用户名或密码不正确");  
		}catch(AuthenticationException ex){
            log.error("登陆失败: " + ex.getMessage());
            model.addAttribute("loginInfo", "登陆失败");
            return "login";
		}
		
	    return "redirect:home";
	}

	
	@RequestMapping(value ="home")
	public String home(Model model){
		log.info("to home page");
		//取出身份信息
		SysUserModel loginUser = (SysUserModel) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("user", loginUser);
	    return "home";
	}

}
