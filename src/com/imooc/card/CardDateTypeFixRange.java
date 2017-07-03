package com.imooc.card;

public class CardDateTypeFixRange extends CardDateInfo {
	private long begin_timestamp;// type为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间。从1970年1月1日00:00:00至起用时间的秒数，最终需转换为字符串形态传入。（东八区时间,UTC+8，单位为秒）
	private long end_timestamp;// 表示结束时间，建议设置为截止日期的23:59:59过期。（东八区时间,UTC+8，单位为秒）

	public long getBegin_timestamp() {
		return begin_timestamp;
	}

	public void setBegin_timestamp(long begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}

	public long getEnd_timestamp() {
		return end_timestamp;
	}

	public void setEnd_timestamp(long end_timestamp) {
		this.end_timestamp = end_timestamp;
	}

}
