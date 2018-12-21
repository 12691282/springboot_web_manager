package com.delta.service.user;


import com.delta.bean.sysUser.SysUserBean;
import com.delta.mybaits.model.sysUser.SysUserModel;
import com.github.pagehelper.PageInfo;

public interface SysUserService {
	
	 /**列表**/
	 PageInfo getSysUserListByBean(SysUserBean bean);
	 /**根据id获取bean对象**/
	 SysUserBean getSysUserBeanById(SysUserBean bean);
	 /**新增 或 修改**/
	 void addOrModifySysUserByBean(SysUserBean bean);
	 /**删除**/
	 void deleteSysUserByBean(SysUserBean bean);
	/***
	 * 查一个用户
	 * @param user
	 * @return
	 */
	SysUserModel findOneUser(SysUserModel user);
}
