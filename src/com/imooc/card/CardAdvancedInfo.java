package com.imooc.card;

public class CardAdvancedInfo {

	private CardUseCondition use_condition;
	private CardAbstract card_abstract;
	private CardTextImageList[] text_image_list;
	private CardTimeLimit[] time_limit;
	private String[] business_service;// 商家服务类型：BIZ_SERVICE_DELIVER
										// 外卖服务；BIZ_SERVICE_FREE_PARK
										// 停车位；BIZ_SERVICE_WITH_PET
										// 可带宠物；BIZ_SERVICE_FREE_WIFI 免费wifi，可多选

	public CardUseCondition getUse_condition() {
		return use_condition;
	}

	public void setUse_condition(CardUseCondition use_condition) {
		this.use_condition = use_condition;
	}

	public CardAbstract getCard_abstract() {
		return card_abstract;
	}

	public void setCard_abstract(CardAbstract card_abstract) {
		this.card_abstract = card_abstract;
	}

	public CardTextImageList[] getText_image_list() {
		return text_image_list;
	}

	public void setText_image_list(CardTextImageList[] text_image_list) {
		this.text_image_list = text_image_list;
	}

	public String[] getBusiness_service() {
		return business_service;
	}

	public void setBusiness_service(String[] business_service) {
		this.business_service = business_service;
	}

	public CardTimeLimit[] getTime_limit() {
		return time_limit;
	}

	public void setTime_limit(CardTimeLimit[] time_limit) {
		this.time_limit = time_limit;
	}
}
