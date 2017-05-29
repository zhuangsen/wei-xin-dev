package com.imooc.card;

public class CardMember extends CardType {

	private String background_pic_url;// 商家自定义会员卡背景图，须先调用上传图片接口将背景图上传至CDN，否则报错，卡面设计请遵循微信会员卡自定义背景设计规范
										// ,像素大小控制在1000像素*600像素以下
	private boolean supply_bonus;// 显示积分，填写true或false，如填写true，积分相关字段均为必填。
	private boolean bonus_url;// 设置跳转外链查看积分详情。仅适用于积分无法通过激活接口同步的情况下使用该字段。
	private boolean supply_balance;// 是否支持储值，填写true或false。如填写true，储值相关字段均为必填。
	private String balance_url;// 设置跳转外链查看余额详情。仅适用于余额无法通过激活接口同步的情况下使用该字段。
	private String prerogative;// 会员卡特权说明。
	private boolean auto_activate;// 设置为true时用户领取会员卡后系统自动将其激活，无需调用激活接口，详情见自动激活。
	// private boolean wx_activate;//
	// 设置为true时会员卡支持一键开卡，不允许同时传入activate_url字段，否则设置wx_activate失效。填入该字段后仍需调用接口设置开卡项方可生效，详情见一键开卡。
	private String activate_url;// 激活会员卡的url。
	private String discount;// 折扣，该会员卡享受的折扣优惠,填10就是九折。

	private String bonus_rules;// 积分规则。
	private String bonus_cleared; // 积分清零规则。
	private String balance_rules;// 储值说明。

	private CardMemberCustomeField custom_field1;// 自定义会员信息类目，会员卡激活后显示,包含name_type(name)和url字段

	public String getBonus_rules() {
		return bonus_rules;
	}

	public void setBonus_rules(String bonus_rules) {
		this.bonus_rules = bonus_rules;
	}

	public String getBonus_cleared() {
		return bonus_cleared;
	}

	public void setBonus_cleared(String bonus_cleared) {
		this.bonus_cleared = bonus_cleared;
	}

	public String getBalance_rules() {
		return balance_rules;
	}

	public void setBalance_rules(String balance_rules) {
		this.balance_rules = balance_rules;
	}

	private CardMemberCustomeCell custom_cell1;
	private CardMemberBonusRule bonus_rule;

	public String getBackground_pic_url() {
		return background_pic_url;
	}

	public void setBackground_pic_url(String background_pic_url) {
		this.background_pic_url = background_pic_url;
	}

	public boolean isSupply_bonus() {
		return supply_bonus;
	}

	public void setSupply_bonus(boolean supply_bonus) {
		this.supply_bonus = supply_bonus;
	}

	public boolean isSupply_balance() {
		return supply_balance;
	}

	public void setSupply_balance(boolean supply_balance) {
		this.supply_balance = supply_balance;
	}

	public String getPrerogative() {
		return prerogative;
	}

	public void setPrerogative(String prerogative) {
		this.prerogative = prerogative;
	}

	public boolean isAuto_activate() {
		return auto_activate;
	}

	public void setAuto_activate(boolean auto_activate) {
		this.auto_activate = auto_activate;
	}

	public String getActivate_url() {
		return activate_url;
	}

	public void setActivate_url(String activate_url) {
		this.activate_url = activate_url;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public CardMemberCustomeField getCustom_field1() {
		return custom_field1;
	}

	public void setCustom_field1(CardMemberCustomeField custom_field1) {
		this.custom_field1 = custom_field1;
	}

	public CardMemberCustomeCell getCustom_cell1() {
		return custom_cell1;
	}

	public void setCustom_cell1(CardMemberCustomeCell custom_cell1) {
		this.custom_cell1 = custom_cell1;
	}

	public CardMemberBonusRule getBonus_rule() {
		return bonus_rule;
	}

	public void setBonus_rule(CardMemberBonusRule bonus_rule) {
		this.bonus_rule = bonus_rule;
	}

	public boolean isBonus_url() {
		return bonus_url;
	}

	public void setBonus_url(boolean bonus_url) {
		this.bonus_url = bonus_url;
	}

	public String getBalance_url() {
		return balance_url;
	}

	public void setBalance_url(String balance_url) {
		this.balance_url = balance_url;
	}

}
