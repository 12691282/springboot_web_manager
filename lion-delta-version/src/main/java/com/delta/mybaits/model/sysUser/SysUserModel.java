package com.delta.mybaits.model.sysUser;


import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 *<pre>
 *  SysUser model 实体类
 *  通过 lion generator 生成，禁止使用商业
 *  时间: 2018-05-20 11:05:38
 *</pre>
 * @author lion
 * @version 1.0
**/


@Table(name="sys_user")
public class SysUserModel implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**主键ID**/
	private Integer userId;
	 /**用户名**/
	private String username;
	private String password;
	 /**用户别名**/
	private String aliasName;
	 /**创建时间**/
	private Date createTime;
	 /**0-正常，1-删除**/
	private String statusFlag;

	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public Integer getUserId(){
		return this.userId;
	}

	public void setUsername(String username){
		this.username = username;
	}
	public String getUsername(){
		return this.username;
	}

	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}

	public void setAliasName(String aliasName){
		this.aliasName = aliasName;
	}
	public String getAliasName(){
		return this.aliasName;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	public Date getCreateTime(){
		return this.createTime;
	}

	public void setStatusFlag(String statusFlag){
		this.statusFlag = statusFlag;
	}
	public String getStatusFlag(){
		return this.statusFlag;
	}

	@Override
	public String toString() {

		 return "SysUserModel{" 
			 + " userId = " + this.userId
			 + " username = " + this.username
			 + " password = " + this.password
			 + " aliasName = " + this.aliasName
			 + " createTime = " + this.createTime
			 + " statusFlag = " + this.statusFlag
			 + " }";
	}

}
