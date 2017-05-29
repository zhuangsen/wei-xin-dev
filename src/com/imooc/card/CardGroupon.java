package com.imooc.card;

/**
 * 团购券
 * 
 * @author madison
 *
 */
public class CardGroupon extends CardType {

	public CardGroupon() {
	}

	public CardGroupon(String deal_detail) {
		this.deal_detail = deal_detail;
	}

	private String deal_detail;

	public String getDeal_detail() {
		return deal_detail;
	}

	public void setDeal_detail(String deal_detail) {
		this.deal_detail = deal_detail;
	}
}
