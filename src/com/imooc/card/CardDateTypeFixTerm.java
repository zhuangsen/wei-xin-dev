package com.imooc.card;

public class CardDateTypeFixTerm extends CardDateInfo {

	private int fixed_term;// type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0。
	private long fixed_begin_term;// 表示结束时间，建议设置为截止日期的23:59:59过期。（东八区时间,UTC+8，单位为秒）
	private long end_timestamp;// 可用于DATE_TYPE_FIX_TERM时间类型，表示卡券统一过期时间，建议设置为截止日期的23:59:59过期。（东八区时间,UTC+8，单位为秒），设置了fixed_term卡券，当时间达到end_timestamp时卡券统一过期

	public int getFixed_term() {
		return fixed_term;
	}

	public void setFixed_term(int fixed_term) {
		this.fixed_term = fixed_term;
	}

	public long getFixed_begin_term() {
		return fixed_begin_term;
	}

	public void setFixed_begin_term(long fixed_begin_term) {
		this.fixed_begin_term = fixed_begin_term;
	}

	public long getEnd_timestamp() {
		return end_timestamp;
	}

	public void setEnd_timestamp(long end_timestamp) {
		this.end_timestamp = end_timestamp;
	}
}
