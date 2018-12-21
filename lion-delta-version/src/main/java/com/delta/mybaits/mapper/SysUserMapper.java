package com.delta.mybaits.mapper;


import java.util.List;

import com.delta.bean.sysUser.SysUserBean;
import com.delta.mybaits.model.sysUser.SysUserModel;
import tk.mybatis.mapper.common.Mapper;


/**
 *<pre>
 *  SysUser  mapper 类
 *  通过 lion generator 生成，禁止使用商业
 *  时间: 2018-05-20 11:05:38
 *</pre>
 * @author lion
 * @version 1.0
**/


public interface SysUserMapper extends Mapper<SysUserModel>{

	/**
	/*  根据SysUserBean类模糊查询
	**/
	List<SysUserModel> findHouseInfoListByBean(SysUserBean bean);


}
