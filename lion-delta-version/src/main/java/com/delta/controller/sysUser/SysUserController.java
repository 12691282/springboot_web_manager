package com.delta.controller.sysUser;


import java.util.Map;

import com.delta.base.BaseController;
import com.delta.bean.sysUser.SysUserBean;
import com.delta.service.user.SysUserService;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;


/**
 *<pre>
 *  SysUser Controller
 *  通过 lion generator 生成，禁止使用商业
 *  时间: 2018-51-20 09:51:45
 *</pre>
 * @author lion
 * @version 1.0
**/


@Controller
@RequestMapping("sysUser")
public class SysUserController extends BaseController{
	/**service服务类**/
	@Autowired
	private SysUserService sysUserService;


	/**列表**/
	@RequestMapping("list")
	public String getSysUserList(Model model,SysUserBean bean){
		bean.prepareData();
		PageInfo pageInfo = sysUserService.getSysUserListByBean(bean);
		model.addAttribute("data", pageInfo); 
		model.addAttribute("query", bean); 
		return "/sysUser/list";
	}

	/**根据id获取对象**/
	@RequestMapping("getBeanById")
	public String getSysUserBeanById(Model model,SysUserBean bean){
		if(bean.getUserId() != null){
			bean = sysUserService.getSysUserBeanById(bean);
		}
		model.addAttribute("sysUser", bean); 
		return "/sysUser/info";
	}

	/***新增 或修改**/
	@RequestMapping("addOrModify")
	@ResponseBody()
	public Map addSysUserBean(SysUserBean bean){
		try{

		bean.prepareData();
			sysUserService.addOrModifySysUserByBean(bean);

		}catch(Exception e){
			return super.getFailureInfo();
		}
		return super.getSuccessInfo();
	}

	/**删除**/
	@RequestMapping("delete")
	@ResponseBody()
	public Map deleteSysUserBean(SysUserBean bean){
		try{

			sysUserService.deleteSysUserByBean(bean);

		}catch(Exception e){
			return super.getFailureInfo();
		}
		return super.getSuccessInfo();
	}

}
