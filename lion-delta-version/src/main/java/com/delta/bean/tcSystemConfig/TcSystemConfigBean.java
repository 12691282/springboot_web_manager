package com.delta.bean.tcSystemConfig;


import java.util.Date;
import org.springframework.util.StringUtils;



/**
 *<pre>
 *  TcSystemConfig bean 实体类
 *  通过 lion generator 生成，禁止使用商业
 *  时间: 2017-45-28 11:45:49
 *</pre>
 * @author lion
 * @version 1.0
**/


public class TcSystemConfigBean{
	private Integer id;
	private String name;
	private String type;
	private String content;
	private Integer status;
	private String notes;

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}

	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return this.content;
	}

	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return this.status;
	}

	public void setNotes(String notes){
		this.notes = notes;
	}
	public String getNotes(){
		return this.notes;
	}

	public void prepareData() {
		if(StringUtils.isEmpty(this.getId())){
			this.setId(null);
		}
		if(StringUtils.isEmpty(this.getName())){
			this.setName(null);
		}
		if(StringUtils.isEmpty(this.getType())){
			this.setType(null);
		}
		if(StringUtils.isEmpty(this.getContent())){
			this.setContent(null);
		}
		if(StringUtils.isEmpty(this.getStatus())){
			this.setStatus(null);
		}
		if(StringUtils.isEmpty(this.getNotes())){
			this.setNotes(null);
		}

	}

	@Override
	public String toString() {

		 return "TcSystemConfigBean{" 
			 + " id = " + this.id
			 + " name = " + this.name
			 + " type = " + this.type
			 + " content = " + this.content
			 + " status = " + this.status
			 + " notes = " + this.notes
			 + " }";
	}
}
