package com.imooc.card;

/**
 * 积分规则。
 * 
 * @author madison
 *
 */
public class CardMemberBonusRule {

	private int cost_money_unit;// 消费金额。以分为单位。
	private int increase_bonus;// 对应增加的积分。
	private int max_increase_bonus;// 用户单次可获取的积分上限。
	private int init_increase_bonus;// 初始设置积分。
	private int cost_bonus_unit;// 每使用5积分。
	private int reduce_money;// 抵扣xx元，（这里以分为单位）
	private int least_money_to_use_bonus;// 抵扣条件，满xx元（这里以分为单位）可用。
	private int max_reduce_bonus;// 抵扣条件，单笔最多使用xx积分。

	public int getCost_money_unit() {
		return cost_money_unit;
	}

	public void setCost_money_unit(int cost_money_unit) {
		this.cost_money_unit = cost_money_unit;
	}

	public int getIncrease_bonus() {
		return increase_bonus;
	}

	public void setIncrease_bonus(int increase_bonus) {
		this.increase_bonus = increase_bonus;
	}

	public int getMax_increase_bonus() {
		return max_increase_bonus;
	}

	public void setMax_increase_bonus(int max_increase_bonus) {
		this.max_increase_bonus = max_increase_bonus;
	}

	public int getInit_increase_bonus() {
		return init_increase_bonus;
	}

	public void setInit_increase_bonus(int init_increase_bonus) {
		this.init_increase_bonus = init_increase_bonus;
	}

	public int getCost_bonus_unit() {
		return cost_bonus_unit;
	}

	public void setCost_bonus_unit(int cost_bonus_unit) {
		this.cost_bonus_unit = cost_bonus_unit;
	}

	public int getReduce_money() {
		return reduce_money;
	}

	public void setReduce_money(int reduce_money) {
		this.reduce_money = reduce_money;
	}

	public int getLeast_money_to_use_bonus() {
		return least_money_to_use_bonus;
	}

	public void setLeast_money_to_use_bonus(int least_money_to_use_bonus) {
		this.least_money_to_use_bonus = least_money_to_use_bonus;
	}

	public int getMax_reduce_bonus() {
		return max_reduce_bonus;
	}

	public void setMax_reduce_bonus(int max_reduce_bonus) {
		this.max_reduce_bonus = max_reduce_bonus;
	}

}
