package com.imooc.card;

/**
 * 优惠券
 * @author madison
 *
 */
public class CardGeneralCoupon extends CardType {

	private String default_detail;
	
	public CardGeneralCoupon(String default_detail) {
		super();
		this.default_detail = default_detail;
	}

	public String getDefault_detail() {
		return default_detail;
	}

	public void setDefault_detail(String default_detail) {
		this.default_detail = default_detail;
	}
}
