package com.imooc.card;

public class BusinessBaseInfo {

	private String sid;// 商户自己的id，用于后续审核通过收到poi_id 的通知时，做对应关系。请商户自己保证唯一识别性
	private String business_name;// 门店名称（仅为商户名，如：国美、麦当劳，不应包含地区、地址、分店名等信息，错误示例：北京国美）不能为空，15个汉字或30个英文字符内
	private String branch_name;// 分店名称（不应包含地区信息，不应与门店名有重复，错误示例：北京王府井店）20个字以内
	private String province;// 门店所在的省份（直辖市填城市名,如：北京市）10个字以内
	private String city;// 门店所在的城市 10个字以内
	private String district;// 门店所在地区 10个字以内
	private String address;// 门店所在的详细街道地址（不要填写省市信息）
	private String telephone;// 门店的电话（纯数字，区号、分机号均由“-”隔开）
	private String categories;// 门店的类型（不同级分类用“,”隔开，如：美食，川菜，火锅。详细分类参见附件：微信门店类目表）
	/**
	 * 坐标类型： 1 为火星坐标 2 为sogou经纬度 3 为百度经纬度 4 为mapbar经纬度 5 为GPS坐标 6 为sogou墨卡托坐标
	 */
	private String offset_type;
	private String longitude;// 门店所在地理位置的经度
	private String latitude;// 门店所在地理位置的纬度（经纬度均为火星坐标，最好选用腾讯地图标记的坐标）
	private String photo_list;// 图片列表，url
								// 形式，可以有多张图片，尺寸为640*340px。必须为上一接口生成的url。图片内容不允许与门店不相关，不允许为二维码、员工合照（或模特肖像）、营业执照、无门店正门的街景、地图截图、公交地铁站牌、菜单截图等
	private String recommend;// 推荐品，餐厅可为推荐菜；酒店为推荐套房；景点为推荐游玩景点等，针对自己行业的推荐内容200字以内
	private String special;// 特色服务，如免费wifi，免费停车，送货上门等商户能提供的特色功能或服务
	private String introduction;// 商户简介，主要介绍商户信息等300字以内
	private String open_time;// 营业时间，24 小时制表示，用“-”连接，如8:00-20:00
	private String avg_price;// 人均价格，大于0 的整数
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getOffset_type() {
		return offset_type;
	}
	public void setOffset_type(String offset_type) {
		this.offset_type = offset_type;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getPhoto_list() {
		return photo_list;
	}
	public void setPhoto_list(String photo_list) {
		this.photo_list = photo_list;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getOpen_time() {
		return open_time;
	}
	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}
	public String getAvg_price() {
		return avg_price;
	}
	public void setAvg_price(String avg_price) {
		this.avg_price = avg_price;
	}
	
}