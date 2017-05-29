package com.imooc.card;

/**
 * 代金券
 * 
 * @author madison
 *
 */
public class CardCash extends CardType {

	private int least_cost;//代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0。
	private int reduce_cost;//代金券专用，表示减免金额。（单位为分）

	public CardCash() {
	}

	public CardCash(int least_cost, int reduce_cost) {
		this.least_cost = least_cost;
		this.reduce_cost = reduce_cost;
	}

	public int getLeast_cost() {
		return least_cost;
	}

	public void setLeast_cost(int least_cost) {
		this.least_cost = least_cost;
	}

	public int getReduce_cost() {
		return reduce_cost;
	}

	public void setReduce_cost(int reduce_cost) {
		this.reduce_cost = reduce_cost;
	}
}
