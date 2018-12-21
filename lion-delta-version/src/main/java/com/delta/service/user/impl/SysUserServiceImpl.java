package com.delta.service.user.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delta.base.BaseService;
import com.delta.bean.sysUser.SysUserBean;
import com.delta.mybaits.mapper.SysUserMapper;
import com.delta.mybaits.model.sysUser.SysUserModel;
import com.delta.service.user.SysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class SysUserServiceImpl  extends BaseService implements SysUserService{
	

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public SysUserModel findOneUser(SysUserModel user) {
	   log.info("find user : " + user);
	   SysUserModel condition = new SysUserModel();
       condition.setUsername(user.getUsername());
       condition.setStatusFlag(SysUserBean.STATU_NORMAL);
       SysUserModel newUser = sysUserMapper.selectOne(condition);
	   if(newUser == null || !newUser.getPassword().equals(user.getPassword())){
		   return null;
	   }
		return newUser;
	}
 

	
	/**列表**/
	@Override
	public PageInfo getSysUserListByBean(SysUserBean bean){
		log.info("getSysUserListByBean bean : " +  bean.toString());
		SysUserModel model = new SysUserModel();
		Page pageInfo = super.setPageNumber();
		sysUserMapper.findHouseInfoListByBean(bean);
		return pageInfo.toPageInfo();
	}

	 /**根据id获取bean对象**/
	@Override
	public SysUserBean getSysUserBeanById(SysUserBean bean){
		SysUserModel model = sysUserMapper.selectByPrimaryKey(bean.getUserId());
		SysUserBean newBean = new SysUserBean();
		BeanUtils.copyProperties(model, newBean);
		 return newBean;
	}

	/**新增 或修改**/
	@Override
	public void addOrModifySysUserByBean(SysUserBean bean){
		log.info("addOrModifySysUserByBean bean  : "   +  bean.toString());

		SysUserModel model = new SysUserModel();
		BeanUtils.copyProperties(bean, model);
		if(bean.getUserId() != null){
			model.setUserId(Integer.valueOf(bean.getUserId()));
			sysUserMapper.updateByPrimaryKey(model);
		}else{
			sysUserMapper.insert(model);
		}
	}

	/**删除**/
	@Override
	public void deleteSysUserByBean(SysUserBean bean){
		log.info("deleteSysUserByBean bean : "  + bean.toString());

		SysUserModel model = new SysUserModel();
		BeanUtils.copyProperties(bean, model);
		if(bean.getUserId() != null){
			model.setUserId(Integer.valueOf(bean.getUserId()));
			sysUserMapper.deleteByPrimaryKey(model);
		}
	}
}
	


