package com.imooc.card;

/**
 * 使用门槛（条件）字段，若不填写使用条件则在券面拼写 ：无最低消费限制，全场通用，不限品类；并在使用说明显示： 可与其他优惠共享
 * 
 * @author madison
 *
 */
public class CardUseCondition {

	private String accept_category;// 指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写适用于xxx
	private String reject_category;// 指定不可用的商品类目，仅用于代金券类型，填入后将在券面拼写不适用于xxxx
	private boolean can_use_with_other_discount;// 不可以与其他类型共享门槛，填写false时系统将在使用须知里拼写“不可与其他优惠共享”，填写true时系统将在使用须知里拼写“可与其他优惠共享”，默认为true

	public String getAccept_category() {
		return accept_category;
	}

	public void setAccept_category(String accept_category) {
		this.accept_category = accept_category;
	}

	public String getReject_category() {
		return reject_category;
	}

	public void setReject_category(String reject_category) {
		this.reject_category = reject_category;
	}

	public boolean isCan_use_with_other_discount() {
		return can_use_with_other_discount;
	}

	public void setCan_use_with_other_discount(boolean can_use_with_other_discount) {
		this.can_use_with_other_discount = can_use_with_other_discount;
	}
}
