package com.imooc.card;

/**
 * 投放卡券post字段
 * 
 * @author madison
 *
 */
public class CardQRCode {

	private String action_name;
	private long expire_seconds;// 指定二维码的有效时间，范围是60 ~ 1800秒。不填默认为365天有效
	private CardActionInfo action_info;

	public String getAction_name() {
		return action_name;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public long getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}

	public CardActionInfo getAction_info() {
		return action_info;
	}

	public void setAction_info(CardActionInfo action_info) {
		this.action_info = action_info;
	}

}
