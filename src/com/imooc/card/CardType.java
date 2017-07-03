package com.imooc.card;

/**
 * 卡券类型: 1.代金券 CardCash 2.团购券 CardGoupon 3.折扣券 CardDiscount 4.兑换券 CardGift 5.优惠券
 * CardGeneralCoupon
 * 
 * 注意事项： 1.高级字段为商户额外展示信息字段，非必填,但是填入某些结构体后，须填充完整方可显示：如填入text_image_list结构体
 * 时，须同时传入image_url和text，否则也会报错； 2.填入时间限制字段（time_limit）,只控制显示，不控制实际使用逻辑，不填默认不显示
 * 3.创建卡券时，开发者填入的时间戳须注意时间戳溢出时间，设置的时间戳须早于2038年1月19日
 * 4.预存code模式的卡券须设置quantity为0，导入code后方可增加库存
 * 
 * @author madison
 *
 */
public class CardType {
	private CardBaseInfo base_info;
	private CardAdvancedInfo advanced_info;// 非必填,但是填入某些结构体后，须填充完整方可显示

	public CardBaseInfo getBase_info() {
		return base_info;
	}

	public void setBase_info(CardBaseInfo base_info) {
		this.base_info = base_info;
	}

	public CardAdvancedInfo getAdvanced_info() {
		return advanced_info;
	}

	public void setAdvanced_info(CardAdvancedInfo advanced_info) {
		this.advanced_info = advanced_info;
	}

}
