package com.imooc.trans;

import java.util.List;

public class Result {

	private String from;
	private String to;
	private List<MyTransResult> trans_result;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public List<MyTransResult> getTrans_result() {
		return trans_result;
	}

	public void setTrans_result(List<MyTransResult> trans_result) {
		this.trans_result = trans_result;
	}

	@Override
	public String toString() {
		return "Result [from=" + from + ", to=" + to + ", trans_result=" + trans_result + "]";
	}

}
