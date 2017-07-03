package com.imooc.card;

public class CardDateInfo {

	/**
	 * 使用时间的类型，旧文档采用的1和2依然生效。 DATE_TYPE_FIX _TIME_RANGE
	 * 表示固定日期区间，DATE_TYPE_FIX_TERM 表示固定时长 （自领取后按天算）
	 */
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
