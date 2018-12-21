package com.delta.bean.sysUser;

import org.springframework.util.StringUtils;



/**
 *<pre>
 *  SysUser bean 实体类
 *  通过 lion generator 生成，禁止使用商业
 *  时间: 2018-51-20 09:51:45
 *</pre>
 * @author lion
 * @version 1.0
**/


public class SysUserBean{
	
	
	public static final String STATU_NORMAL = "0"; //0-正常
	public static final String STATU_DELETE = "1"; //1-删除
	
	 /**主键ID**/
	private String userId;
	 /**用户名**/
	private String username;
	private String password;
	 /**用户别名**/
	private String aliasName;
	 /**创建时间**/
	private String createTime;
	 /**0-正常，1-删除**/
	private String statusFlag;

	public void setUserId(String  userId){
		this.userId = userId;
	}
	public String getUserId(){
		return this.userId;
	}

	public void setUsername(String  username){
		this.username = username;
	}
	public String getUsername(){
		return this.username;
	}

	public void setPassword(String  password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}

	public void setAliasName(String  aliasName){
		this.aliasName = aliasName;
	}
	public String getAliasName(){
		return this.aliasName;
	}

	public void setCreateTime(String  createTime){
		this.createTime = createTime;
	}
	public String getCreateTime(){
		return this.createTime;
	}

	public void setStatusFlag(String  statusFlag){
		this.statusFlag = statusFlag;
	}
	public String getStatusFlag(){
		return this.statusFlag;
	}

	public void prepareData() {
		if(StringUtils.isEmpty(this.getUserId())){
			this.setUserId(null);
		}
		if(StringUtils.isEmpty(this.getUsername())){
			this.setUsername(null);
		}
		if(StringUtils.isEmpty(this.getPassword())){
			this.setPassword(null);
		}
		if(StringUtils.isEmpty(this.getAliasName())){
			this.setAliasName(null);
		}
		if(StringUtils.isEmpty(this.getCreateTime())){
			this.setCreateTime(null);
		}
		if(StringUtils.isEmpty(this.getStatusFlag())){
			this.setStatusFlag(null);
		}

	}

	@Override
	public String toString() {

		 return "SysUserBean{" 
			 + " userId = " + this.userId
			 + " username = " + this.username
			 + " password = " + this.password
			 + " aliasName = " + this.aliasName
			 + " createTime = " + this.createTime
			 + " statusFlag = " + this.statusFlag
			 + " }";
	}
}
