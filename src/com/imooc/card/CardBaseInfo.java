package com.imooc.card;

public class CardBaseInfo {
	
	//***************必填字段***************//
	private String logo_url; // 卡券的商户logo，建议像素为300*300。
	private String brand_name;// 商户名字,字数上限为12个汉字。
	/**
	 * 码型： "CODE_TYPE_TEXT"文本； "CODE_TYPE_BARCODE"一维码 "CODE_TYPE_QRCODE"二维码
	 * "CODE_TYPE_ONLY_QRCODE",二维码无code显示；
	 * "CODE_TYPE_ONLY_BARCODE",一维码无code显示；CODE_TYPE_NONE， 不显示code和条形码类型
	 */
	private String code_type;
	private String title;// 卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。
	private String color;// 券颜色。按色彩规范标注填写Color010-Color100。
	private String notice;// 卡券使用提醒，字数上限为16个汉字。
	private String description;// 卡券使用说明，字数上限为1024个汉字。
	private CardDateInfo date_info;// 使用日期，有效期的信息。
	private CardSku sku;// 商品信息。
	
	//***************非必填字段***************//
	private long use_limit;//每人可核销的数量限制,不填写默认为50。
	private long get_limit;//每人可领券的数量限制,不填写默认为50。
	private String service_phone;// 客服电话。
	private boolean use_custom_code;// 是否自定义Code码。填写true或false，默认为false。通常自有优惠码系统的开发者选择自定义Code码，并在卡券投放时带入Code码，详情见是否自定义Code码。
	private String get_custom_code_mode; // 填入GET_CUSTOM_CODE_MODE_DEPOSIT表示该卡券为预存code模式卡券，须导入超过库存数目的自定义code后方可投放，填入该字段后，quantity字段须为0,须导入code后再增加库存
	private boolean bind_openid;//是否指定用户领取，填写true或false。默认为false。通常指定特殊用户群体投放卡券或防止刷券时选择指定用户领取。
	private boolean can_share;//卡券领取页面是否可分享。
	private boolean can_give_friend;//卡券是否可转赠。
	private long[] location_id_list;//门店位置poiid。调用POI门店管理接口获取门店位置poiid。具备线下门店的商户为必填。
	private boolean use_all_locations; //设置本卡券支持全部门店，与location_id_list互斥
	private String center_title;//卡券顶部居中的按钮，仅在卡券状态正常(可以核销)时显示
	private String center_sub_title;//显示在入口下方的提示语，仅在卡券状态正常(可以核销)时显示。
	private String center_url;//顶部居中的url，仅在卡券状态正常(可以核销)时显示。
	private String custom_url_name;//自定义跳转外链的入口名字。详情见活用自定义入口
	private String custom_url;//自定义跳转的URL。
	private String custom_url_sub_title;//显示在入口右侧的提示语。
	private String promotion_url_name;//营销场景的自定义入口名称。
	private String promotion_url;//入口跳转外链的地址链接。
	private String promotion_url_sub_title;//显示在营销入口右侧的提示语。
	private String source;//第三方来源名，例如同程旅游、大众点评。

	public String getLogo_url() {
		return logo_url;
	}

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getCode_type() {
		return code_type;
	}

	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getService_phone() {
		return service_phone;
	}

	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CardSku getSku() {
		return sku;
	}

	public void setSku(CardSku sku) {
		this.sku = sku;
	}

	public long getUse_limit() {
		return use_limit;
	}

	public void setUse_limit(long use_limit) {
		this.use_limit = use_limit;
	}

	public long getGet_limit() {
		return get_limit;
	}

	public void setGet_limit(long get_limit) {
		this.get_limit = get_limit;
	}

	public boolean isUse_custom_code() {
		return use_custom_code;
	}

	public void setUse_custom_code(boolean use_custom_code) {
		this.use_custom_code = use_custom_code;
	}

	public boolean isBind_openid() {
		return bind_openid;
	}

	public void setBind_openid(boolean bind_openid) {
		this.bind_openid = bind_openid;
	}

	public boolean isCan_share() {
		return can_share;
	}

	public void setCan_share(boolean can_share) {
		this.can_share = can_share;
	}

	public boolean isCan_give_friend() {
		return can_give_friend;
	}

	public void setCan_give_friend(boolean can_give_friend) {
		this.can_give_friend = can_give_friend;
	}

	public long[] getLocation_id_list() {
		return location_id_list;
	}

	public void setLocation_id_list(long[] location_id_list) {
		this.location_id_list = location_id_list;
	}

	public String getCenter_title() {
		return center_title;
	}

	public void setCenter_title(String center_title) {
		this.center_title = center_title;
	}

	public String getCenter_sub_title() {
		return center_sub_title;
	}

	public void setCenter_sub_title(String center_sub_title) {
		this.center_sub_title = center_sub_title;
	}

	public String getCenter_url() {
		return center_url;
	}

	public void setCenter_url(String center_url) {
		this.center_url = center_url;
	}

	public String getCustom_url_name() {
		return custom_url_name;
	}

	public void setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
	}

	public String getCustom_url() {
		return custom_url;
	}

	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}

	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}

	public void setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
	}

	public String getPromotion_url_name() {
		return promotion_url_name;
	}

	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}

	public String getPromotion_url() {
		return promotion_url;
	}

	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public CardDateInfo getDate_info() {
		return date_info;
	}

	public void setDate_info(CardDateInfo date_info) {
		this.date_info = date_info;
	}

	public String getGet_custom_code_mode() {
		return get_custom_code_mode;
	}

	public void setGet_custom_code_mode(String get_custom_code_mode) {
		this.get_custom_code_mode = get_custom_code_mode;
	}

	public boolean isUse_all_locations() {
		return use_all_locations;
	}

	public void setUse_all_locations(boolean use_all_locations) {
		this.use_all_locations = use_all_locations;
	}

	public String getPromotion_url_sub_title() {
		return promotion_url_sub_title;
	}

	public void setPromotion_url_sub_title(String promotion_url_sub_title) {
		this.promotion_url_sub_title = promotion_url_sub_title;
	}

}
