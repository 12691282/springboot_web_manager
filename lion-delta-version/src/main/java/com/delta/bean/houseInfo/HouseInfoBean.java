package com.delta.bean.houseInfo;


import org.springframework.util.StringUtils;



/**
 *<pre>
 *  HouseInfo bean 实体类
 *  通过 lion generator 生成，禁止使用商业
 *  时间: 2017-57-19 14:57:21
 *</pre>
 * @author lion
 * @version 1.0
**/


public class HouseInfoBean{
	 /**主键**/
	private String id;
	 /**楼盘名称**/
	private String houseName;
	 /**楼盘主页连接**/
	private String pageUrl;
	 /**楼盘价格**/
	private String housePrice;
	 /**楼盘用途**/
	private String housePurpose;
	 /**楼盘区域**/
	private String houseArea;
	 /**创建时间**/
	private String createTime;
	 /** 查询时间对 **/
	private String createTimeStart;
	private String createTimeEnd;

	public void setId(String  id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}

	public void setHouseName(String  houseName){
		this.houseName = houseName;
	}
	public String getHouseName(){
		return this.houseName;
	}

	public void setPageUrl(String  pageUrl){
		this.pageUrl = pageUrl;
	}
	public String getPageUrl(){
		return this.pageUrl;
	}

	public void setHousePrice(String  housePrice){
		this.housePrice = housePrice;
	}
	public String getHousePrice(){
		return this.housePrice;
	}

	public void setHousePurpose(String  housePurpose){
		this.housePurpose = housePurpose;
	}
	public String getHousePurpose(){
		return this.housePurpose;
	}

	public void setHouseArea(String  houseArea){
		this.houseArea = houseArea;
	}
	public String getHouseArea(){
		return this.houseArea;
	}

	public void setCreateTime(String  createTime){
		this.createTime = createTime;
	}
	public String getCreateTime(){
		return this.createTime;
	}

	public void setCreateTimeStart(String  createTimeStart){
		this.createTimeStart = createTimeStart;
	}
	public String getCreateTimeStart(){
		return this.createTimeStart;
	}

	public void setCreateTimeEnd(String  createTimeEnd){
		this.createTimeEnd = createTimeEnd;
	}
	public String getCreateTimeEnd(){
		return this.createTimeEnd;
	}

	public void prepareData() {
		if(StringUtils.isEmpty(this.getId())){
			this.setId(null);
		}
		if(StringUtils.isEmpty(this.getHouseName())){
			this.setHouseName(null);
		}
		if(StringUtils.isEmpty(this.getPageUrl())){
			this.setPageUrl(null);
		}
		if(StringUtils.isEmpty(this.getHousePrice())){
			this.setHousePrice(null);
		}
		if(StringUtils.isEmpty(this.getHousePurpose())){
			this.setHousePurpose(null);
		}
		if(StringUtils.isEmpty(this.getHouseArea())){
			this.setHouseArea(null);
		}
		if(StringUtils.isEmpty(this.getCreateTime())){
			this.setCreateTime(null);
		}
		if(StringUtils.isEmpty(this.getCreateTimeStart())){
			this.setCreateTimeStart(null);
		}
		if(StringUtils.isEmpty(this.getCreateTimeEnd())){
			 this.setCreateTimeEnd(null);
		}

	}

	@Override
	public String toString() {

		 return "HouseInfoBean{" 
			 + " id = " + this.id
			 + " houseName = " + this.houseName
			 + " pageUrl = " + this.pageUrl
			 + " housePrice = " + this.housePrice
			 + " housePurpose = " + this.housePurpose
			 + " houseArea = " + this.houseArea
			 + " createTime = " + this.createTime
			 + " }";
	}
}
