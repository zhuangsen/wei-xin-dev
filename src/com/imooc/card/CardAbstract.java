package com.imooc.card;

/**
 * 封面摘要结构体名称
 * @author madison
 *
 */
public class CardAbstract {

	private String card_abstract;// 封面摘要简介。
	private String[] icon_url_list;// 封面图片列表，仅支持填入一个封面图片链接，上传图片接口上传获取图片获得链接，填写非CDN链接会报错，并在此填入。建议图片尺寸像素850*350

	public String getCard_abstract() {
		return card_abstract;
	}

	public void setCard_abstract(String card_abstract) {
		this.card_abstract = card_abstract;
	}

	public String[] getIcon_url_list() {
		return icon_url_list;
	}

	public void setIcon_url_list(String[] icon_url_list) {
		this.icon_url_list = icon_url_list;
	}
}
