package com.imooc.card;

/**
 * 图文列表，显示在详情内页 ，优惠券券开发者须至少传入 一组图文列表
 * 
 * @author madison
 *
 */
public class CardTextImageList {

	private String image_url;//图片链接，必须调用上传图片接口上传图片获得链接，并在此填入，否则报错
	private String text;//图文描述

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
