package com.imooc.card;

/**
 * 自定义会员信息类目，会员卡激活后显示。
 * 
 * @author madison
 *
 */
public class CardMemberCustomeCell {

	private String name;// 入口名称。
	private String tips;// 入口右侧提示语，6个汉字内。
	private String url;// 入口跳转链接。

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
