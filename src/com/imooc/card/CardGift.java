package com.imooc.card;

/**
 * 兑换券
 * 
 * @author madison
 *
 */
public class CardGift extends CardType {

	public CardGift() {
	}

	public CardGift(String gift) {
		this.gift = gift;
	}

	private String gift;

	public String getGift() {
		return gift;
	}

	public void setGift(String gift) {
		this.gift = gift;
	}
}
