package com.imooc.card;

/**
 * 卡券
 * 
 * { "errcode":0, "errmsg":"ok", "card_id":"p1Pj9jr90_SQRaVqYI239Ka1erkI" }
 * 
 * @author madison
 *
 */
public class Card {

	private String card_type;
//	private CardType general_coupon;
	private CardType cash;

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

//	public CardType getGeneral_coupon() {
//		return general_coupon;
//	}
//
//	public void setGeneral_coupon(CardType general_coupon) {
//		this.general_coupon = general_coupon;
//	}

	public CardType getCash() {
		return cash;
	}

	public void setCash(CardType cash) {
		this.cash = cash;
	}

}
