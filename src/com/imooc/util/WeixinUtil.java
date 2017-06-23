package com.imooc.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.imooc.card.Card;
import com.imooc.card.CardAbstract;
import com.imooc.card.CardActionInfo;
import com.imooc.card.CardAdvancedInfo;
import com.imooc.card.CardBaseInfo;
import com.imooc.card.CardDateTypeFixRange;
import com.imooc.card.CardGift;
import com.imooc.card.CardInActionInfo;
import com.imooc.card.CardQRCode;
import com.imooc.card.CardSku;
import com.imooc.card.CardTextImageList;
import com.imooc.card.CardTimeLimit;
import com.imooc.card.CardType;
import com.imooc.card.CardUseCondition;
import com.imooc.card.Cards;
import com.imooc.menu.Button;
import com.imooc.menu.ClickButton;
import com.imooc.menu.MediaButton;
import com.imooc.menu.Menu;
import com.imooc.menu.MiniProgramButton;
import com.imooc.menu.ViewButton;
import com.imooc.po.AccessToken;
import com.imooc.po.Article;
import com.imooc.po.Articles;
import com.imooc.po.WhiteList;
import com.imooc.trans.Data;
import com.imooc.trans.Parts;
import com.imooc.trans.Symbols;
import com.imooc.trans.TransResult;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 微信工具类
 *
 */
public class WeixinUtil {
	public static final String APPID = "wx556e5b2e4d4b827a";
	public static final String APPSECRET = "dd8ee32598397b58b0f34881c3bc7079";
	
	public static final String MADISON_OPENID = "oY5mJw5d7G78pHVkXrwXJVHkDr_Y";

	public static final String TEST_APPID = "wx73834ad5aa2dfaa7";
	public static final String TEST_APPSECRET = "1f6301ee7a66d882e6afeac6fe07237e";

	private static final String USER_NAME_MADISON = "ZhuangSen--_--";
	private static final String USER_NAME_IVAN = "Ivan_Madison";
	private static final String USER_NAME_BAO = "x861281331";
	private static final String USER_NAME_CHANG = "changlock";
	private static final String USER_NAME_DONG = "xiangyangdongdong";
	private static final String USER_NAME_LIANG = "wxid_bd1nu4e9q8b912";
	private static final String USER_NAME_CHEN = "cc815211727";
	private static final String USER_NAME_TINA = "yl459668064";

	public static final String ACCESS_TOKEN = "bWHfdwp-HXu93LXU5z0HpOkt_dBUYk8VKx2WxPWSGssQmuyUDL7xIC1uQRB4oBaz4ebBqv0UkO-rD8_IHd8ejW7-KmJBtB6P7F06KqCtGvTgtGE3mDd27mi-CwcURkgcXKGiADAHUQ";

	public static final String IMAGE_MEDIA_ID = "cO8ZMtvh2aaPpLMZnUWRwi0yxsYehf7dKUt6C4aOgWTp1-vgK3f6Bpo-7Qq3QLyN";
	public static final String THUMB_MEDIA_ID = "mRDvVozWpj-fcrM00MjZnClQsE7Ez6G-YXcprJ4POInrczFCadMBqbfLWjI0y6VK";
	public static final String VOICE_MEDIA_ID = "3nMtF8o0A9lsZJn9Wke04nj8Tdm6mJOqFExlzLNomYZ_xZ9uN8xLrGVuAT3kuDWI";
	public static final String VIDEO_MEDIA_ID = "D9ZH8lm5Rp0qEHgISwFcnDozDESbCPlwHn-uO5tiddTo2uImrEK8134EUvIDDkmI";

	// public static final String ETERNAL_IMAGE_MEDIA_ID =
	// "hxPHGVxpzKRlb05H0LrfWiXBrxz2t0RvDX7IyBRwj8o";
	public static final String ETERNAL_IMAGE_MEDIA_ID = "hxPHGVxpzKRlb05H0LrfWtzbUoYYXLjC0m5kfJvmYJo";
	public static final String ETERNAL_THUMB_MEDIA_ID = "hxPHGVxpzKRlb05H0LrfWo8O5koU2yrIrY0xQoe19CU";
	public static final String ETERNAL_VOICE_MEDIA_ID = "3nMtF8o0A9lsZJn9Wke04nj8Tdm6mJOqFExlzLNomYZ_xZ9uN8xLrGVuAT3kuDWI";
	public static final String ETERNAL_VIDEO_MEDIA_ID = "hxPHGVxpzKRlb05H0LrfWhjPzyk2RnaW7uByNrH2yvQ";
	public static final String ETERNAL_NEWS_MEDIA_ID = "hxPHGVxpzKRlb05H0LrfWu8yG_IsPKbQRod1slfmd6o";

	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	public static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	public static final String ADD_NEWS_URL = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
	public static final String UPLOAD_IMG_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
	public static final String ADD_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";

	// 上传图文消息内的图片获取的URL
	public static final String ETERNAL_IMAGE_URL = "http://mmbiz.qpic.cn/mmbiz_jpg/JNF4MLsWR7dU7FlAv02hsUr2boFZhqpX0bB3dDw0GZDQVKd97QngiaxrwJjrJYgqpxiaIx6w853cUtjDx3K6Qmzg/0";
	public static final String NEWS_IMAGE_URL = "http://mmbiz.qpic.cn/mmbiz_jpg/JNF4MLsWR7ftHxTB9bSje3EKeVGZ9u0dnsoNURd6ibOXgqUSYWyU1mcTStL93ic4IrAOTTso2NbQVUEboMxFwTbA/0";
	public static final String ETERNAL_IMAGE_XIANGLIAN_URL = "http://mmbiz.qpic.cn/mmbiz_jpg/JNF4MLsWR7fRMESGIribicICFNW3YMhs0dvMEtmlKxXzaRAkWbMToKWMsCI7zbvL5GvVedjezINyaWlriaOJjicj1A/0?wx_fmt=jpeg";

	private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	private static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	public static final String PROJECT_LINK = "http://zhuangsen.tunnel.qydev.com/wei-xin";
	public static final String RESOURCES_PATH = "/resources/music.mp3";

	/*********** 微信卡片功能接口 ******************/
	public static final String TEST_WHITE_LIST = "https://api.weixin.qq.com/card/testwhitelist/set?access_token=TOKEN";// 設置白名单接口
	public static final String ADD_POI = "http://api.weixin.qq.com/cgi-bin/poi/addpoi?access_token=TOKEN";// 创建门店接口
	public static final String CREATE_CARD_URL = "https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN";// 創建卡券接口
	public static final String QRCODE_CARD_URL = "https://api.weixin.qq.com/card/qrcode/create?access_token=TOKEN";// 投放卡券

	private static final String GENERAL_COUPON_CARD_ID = "pY5mJwyLwxameRlI9ckDFGgisaxY";// 优惠券卡券id
	private static final String GENERAL_COUPON_ADVANCE_INFO_CARD_ID = "pY5mJw38UVov5yK1QDLgFXVGf9fg";// 优惠券高级功能卡券id

	private static final String CASH_CARD_ID = "pY5mJwy8z_2OW3pb96NzhRQsKztE";// 代金券卡券ID
	private static final String CASH_ADVANCE_INFO_CARD_ID = "pY5mJwwwbPptfHRIDn_5ygZ3-Kts";// 代金券高級功能卡券ID

	private static final String GIFT_CARD_ID = "pY5mJw6oUMu2JKOT75DCMEW_3WJQ";// 兑换券卡券ID

	private static final String MEMBER_CARD_ID = "pY5mJw4FBaUg05VorZGPFtuMUa5A";

	private static final String CARD_TICKET_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";// 通过ticket换取二维码
	private static final String CARD_TICKET = "gQFq8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAySDRBUkJ1enBlOTMxY0ZCR05wNFgAAgQh3ipZAwQIBwAA";// ticket

	/**
	 * get请求
	 * 
	 * @param url
	 * @return jsonObject
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject doGetStr(String url) throws ParseException, IOException {
		// DefaultHttpClient client = new DefaultHttpClient();
		// CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		// HttpResponse httpResponse = client.execute(httpGet);
		CloseableHttpResponse httpResponse = client.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		if (entity != null) {
			String result = EntityUtils.toString(entity, "UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		return jsonObject;
	}

	/**
	 * POST请求
	 * 
	 * @param url
	 * @param outStr
	 * @return jsonObject
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject doPostStr(String url, String outStr) throws ParseException, IOException {
		// DefaultHttpClient client = new DefaultHttpClient();
		CloseableHttpClient client = HttpClients.createDefault();
		// CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost httpost = new HttpPost(url);
		JSONObject jsonObject = null;
		httpost.setEntity(new StringEntity(outStr, "UTF-8"));
		// HttpResponse response = client.execute(httpost);
		CloseableHttpResponse response = client.execute(httpost);
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");
		jsonObject = JSONObject.fromObject(result);
		return jsonObject;
	}

	/**
	 * 上传素材文件
	 * 
	 * @param filePath
	 * @param accessToken
	 * @param type
	 * @return mediaId
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 */
	public static void upload(String filePath, String uploadUrl, String type)
			throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {

		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}

		String url = uploadUrl.replace("ACCESS_TOKEN", ACCESS_TOKEN);
		if (StringUtils.isNotBlank(type)) {
			url = url.replace("TYPE", type);
		}

		URL urlObj = new URL(url);
		// 连接
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

		con.setRequestMethod("POST");
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false);

		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		// 设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

		StringBuilder sb = new StringBuilder();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		if (uploadUrl.equals(UPLOAD_URL)) {
			sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
		} else {// if(type.equals("image") || type.equals("thumb") ||
				// type.equals("voice")){
			sb.append("Content-Disposition: form-data;name=\"media\";filename=\"" + file.getName() + "\"\r\n");
		}
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");

		// 获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		// 输出表头
		out.write(head);

		// 文件正文部分
		// 把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}

		in.close();

		if (type.equals("video")) {
			sb = new StringBuilder("--" + BOUNDARY + "\r\nr");
			sb.append("Content-Disposition: form-data;name=\"description\";\r\n\r\n");
			sb.append(String.format("{\"title\":\"%s\", \"introduction\":\"%s\"}", "哈哈video", "videointroduction")
					+ "\"\r\n");
			head = sb.toString().getBytes("utf-8");
			out.write(head);
		}
		// 结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n\r\n").getBytes("utf-8");// 定义最后数据分隔线

		out.write(foot);

		out.flush();
		out.close();

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		JSONObject jsonObj = JSONObject.fromObject(result);
		System.out.println("文件上传-------" + jsonObj);
		// String typeName = "media_id";
		// if ("thumb".equals(type)) {
		// typeName = type + "_media_id";
		// }
		// String mediaId = jsonObj.getString(typeName);
		// return mediaId;
	}

	/**
	 * 获取accessToken
	 * 
	 * @return token
	 * @throws ParseException
	 * @throws IOException
	 */
	public static AccessToken getAccessToken() throws ParseException, IOException {
		AccessToken token = new AccessToken();
		String url = ACCESS_TOKEN_URL.replace("APPID", TEST_APPID).replace("APPSECRET", TEST_APPSECRET);
		JSONObject jsonObject = doGetStr(url);
		if (jsonObject != null) {
			token.setToken(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
		}
		return token;
	}

	/**
	 * 设置白名单
	 * 
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject setWhiteList() throws ParseException, IOException {
		String[] strings = new String[] { USER_NAME_MADISON, USER_NAME_IVAN, USER_NAME_BAO, USER_NAME_CHANG,
				USER_NAME_DONG, USER_NAME_LIANG, USER_NAME_CHEN, USER_NAME_TINA };
		WhiteList list = new WhiteList();
		list.setUsername(strings);
		String whiteList = JSONObject.fromObject(list).toString();
		System.out.println(whiteList);

		String white_list_url = TEST_WHITE_LIST.replace("TOKEN", ACCESS_TOKEN);
		JSONObject jsonObject = doPostStr(white_list_url, whiteList);
		return jsonObject;
	}

	/**
	 * 组装菜单
	 * 
	 * @return menu
	 */
	@SuppressWarnings("unused")
	private static Menu initMenu() {
		Menu menu = new Menu();
		ClickButton button11 = new ClickButton();
		button11.setName("click菜单");
		button11.setType("click");
		button11.setKey("11");

		ViewButton button21 = new ViewButton();
		button21.setName("view菜单");
		button21.setType("view");
		button21.setUrl("http://www.imooc.com");

		ClickButton button31 = new ClickButton();
		button31.setName("扫码事件");
		button31.setType("scancode_push");
		button31.setKey("31");

		ClickButton button32 = new ClickButton();
		button32.setName("地理位置");
		button32.setType("location_select");
		button32.setKey("32");

		Button button = new Button();
		button.setName("菜单");
		button.setSub_button(new Button[] { button31, button32 });

		menu.setButton(new Button[] { button11, button21, button });
		return menu;
	}

	/**
	 * 封装自定义菜单
	 * 
	 * @return menu
	 */
	private static Menu initMyMenu() {
		Menu menu = new Menu();

		// ClickButton todaySong = new ClickButton();
		// todaySong.setType("click");
		// todaySong.setName("今日歌曲");
		// todaySong.setKey("V1001_TODAY_MUSIC");

		Button fatu = new Button();
		fatu.setName("发图");
		ClickButton pic_sysphoto = new ClickButton();
		pic_sysphoto.setName("系统拍照发图");
		pic_sysphoto.setType("pic_sysphoto");
		pic_sysphoto.setKey("rselfmenu_1_0");
		ClickButton pic_photo_or_album = new ClickButton();
		pic_photo_or_album.setName("拍照或者相册发图");
		pic_photo_or_album.setType("pic_photo_or_album");
		pic_photo_or_album.setKey("rselfmenu_1_1");
		ClickButton pic_weixin = new ClickButton();
		pic_weixin.setName("微信相册发图");
		pic_weixin.setType("pic_weixin");
		pic_weixin.setKey("rselfmenu_1_2");
		fatu.setSub_button(new Button[] { pic_sysphoto, pic_photo_or_album, pic_weixin });

		Button saoma = new Button();
		saoma.setName("扫码");
		ClickButton scancode_waitmsg = new ClickButton();
		scancode_waitmsg.setName("扫码带提示");
		scancode_waitmsg.setType("scancode_waitmsg");
		scancode_waitmsg.setKey("rselfmenu_0_0");
		ClickButton scancode_push = new ClickButton();
		scancode_push.setName("扫码推事件");
		scancode_push.setType("scancode_push");
		scancode_push.setKey("rselfmenu_0_1");
		saoma.setSub_button(new Button[] { scancode_waitmsg, scancode_push });

		Button button = new Button();
		button.setName("菜单");
		MediaButton tupian = new MediaButton();
		tupian.setName("图片");
		tupian.setType("media_id");
		tupian.setMedia_id(ETERNAL_VIDEO_MEDIA_ID);
		MediaButton tuwen = new MediaButton();
		tuwen.setName("图文消息");
		tuwen.setType("media_id");
		tuwen.setMedia_id(ETERNAL_VIDEO_MEDIA_ID);
		ClickButton location = new ClickButton();
		location.setName("发送位置");
		location.setType("location_select");
		location.setKey("rselfmenu_2_0");
		ViewButton search = new ViewButton();
		search.setType("view");
		search.setName("搜索");
		search.setUrl("http://www.soso.com/");
		MiniProgramButton miniProgramButton = new MiniProgramButton();
		miniProgramButton.setName("wx");
		miniProgramButton.setType("miniprogram");
		miniProgramButton.setAppid("wx286b93c14bbf93aa");
		miniProgramButton.setUrl("http://mp.weixin.qq.com");
		miniProgramButton.setPagepath("pages/lunar/index.html");
		ClickButton zan = new ClickButton();
		zan.setName("赞一下我们");
		zan.setType("click");
		zan.setKey("V1001_GOOD");
		button.setSub_button(new Button[] { tupian, tuwen, location, search, zan });

		menu.setButton(new Button[] { fatu, saoma, button });

		return menu;
	}

	/**
	 * 初始化创建卡券post数据
	 * 
	 * @return
	 */
	private static Cards initCard() {
		Cards cards = new Cards();

		Card card = new Card();

		card.setCard_type("GENERAL_COUPON");// 优惠券
		card.setCard_type("CASH");// 代金券
		card.setCard_type("GIFT");// 兑换券

		// CardType groupon = new CardGroupon("以下锅底2选1（有菌王锅、麻辣锅、大骨锅、番茄锅、清补
		// 凉锅、酸菜鱼锅可选）： 大锅1份 12元 小锅2份 16元 ");
		// CardType cardType = new
		// CardGeneralCoupon("优惠券:以下锅底2选1（有菌王锅、麻辣锅、大骨锅、番茄锅、清补凉锅、酸菜鱼锅可选）： 大锅1份
		// 12元 小锅2份 16元 ");//优惠券
		// CardType cardType = new CardCash(0, 100);// 代金券
		CardType cardType = new CardGift("可兑换项链一条");

		// 必要字段
		CardBaseInfo baseInfo = new CardBaseInfo();
		baseInfo.setLogo_url(ETERNAL_IMAGE_XIANGLIAN_URL);
		baseInfo.setBrand_name("FORMYROSE");
		baseInfo.setCode_type("CODE_TYPE_QRCODE");
		baseInfo.setTitle("520元兑换券!");
		// baseInfo.setColor("Color080");
		baseInfo.setColor("Color100");
		baseInfo.setNotice("使用时向服务员出示此券");
		baseInfo.setDescription("店内均可使用，提前祝您端午节快乐！");

		CardDateTypeFixRange dateInfo = new CardDateTypeFixRange();
		dateInfo.setType("DATE_TYPE_FIX_TIME_RANGE");
		Calendar date = Calendar.getInstance();
		dateInfo.setBegin_timestamp(date.getTimeInMillis() / 1000);
		date.add(Calendar.DAY_OF_MONTH, 30);
		date.set(Calendar.HOUR_OF_DAY, 23);
		date.set(Calendar.MINUTE, 59);
		date.set(Calendar.SECOND, 59);
		dateInfo.setEnd_timestamp(date.getTimeInMillis() / 1000);
		baseInfo.setDate_info(dateInfo);
		baseInfo.setUse_limit(50);
		baseInfo.setGet_limit(50);
		baseInfo.setService_phone("17612168170");
		baseInfo.setCan_share(true);
		baseInfo.setCan_give_friend(true);

		CardSku sku = new CardSku();
		sku.setQuantity(10);
		baseInfo.setSku(sku);

		// 非必要字段
		// baseInfo.setCenter_url("www.baidu.com");
		// baseInfo.setCenter_title("满110元可用");
		// baseInfo.setCenter_sub_title("满100元可用");
		//
		// baseInfo.setCustom_url_name("更多优惠等你来~");
		// baseInfo.setCustom_url("www.baidu.com");
		// baseInfo.setCenter_title("优惠多多哟~");

		// advanced_info
		CardAdvancedInfo advancedInfo = new CardAdvancedInfo();
		CardUseCondition useCondition = new CardUseCondition();
		useCondition.setAccept_category("蒂凡尼、卡地亚、宝格丽等品牌");
		// useCondition.setReject_category("阿迪达斯");
		useCondition.setCan_use_with_other_discount(true);
		advancedInfo.setUse_condition(useCondition);
		CardAbstract cardAbstract = new CardAbstract();
		cardAbstract.setCard_abstract("一生只为一人定制");
		cardAbstract.setIcon_url_list(new String[] { ETERNAL_IMAGE_URL, ETERNAL_IMAGE_XIANGLIAN_URL });
		advancedInfo.setCard_abstract(cardAbstract);
		CardTextImageList cardTextImageList = new CardTextImageList();
		cardTextImageList.setText("FORMYROSE真爱项链,秉承一生只为一人定制的创始理念.以非凡品质,融合情感与时尚设计,创作出FORMYROSE独特风格");
		cardTextImageList.setImage_url(ETERNAL_IMAGE_XIANGLIAN_URL);
		advancedInfo.setText_image_list(new CardTextImageList[] { cardTextImageList });
		CardTimeLimit cardTimeLimit = new CardTimeLimit();
		cardTimeLimit.setType("MONDAY");
		cardTimeLimit.setBegin_hour(8);
		cardTimeLimit.setEnd_hour(22);
		cardTimeLimit.setBegin_minute(0);
		cardTimeLimit.setEnd_minute(0);
		advancedInfo.setTime_limit(new CardTimeLimit[] { cardTimeLimit });
		advancedInfo.setBusiness_service(new String[] { "BIZ_SERVICE_FREE_PARK", "BIZ_SERVICE_DELIVER",
				"BIZ_SERVICE_WITH_PET", "BIZ_SERVICE_FREE_WIFI" });
		advancedInfo.setBusiness_service(new String[] {});

		cardType.setAdvanced_info(advancedInfo);
		cardType.setBase_info(baseInfo);

		// card.setGroupon(cardType);
		// card.setGeneral_coupon(cardType);
		// card.setCash(cardType);
		card.setGift(cardType);

		cards.setCard(card);
		return cards;
	}

	/**
	 * 初始化投放卡券post數據
	 * 
	 * @return
	 */
	private static CardQRCode initQRCodeCard() {
		CardQRCode cardQRCode = new CardQRCode();
		cardQRCode.setAction_name("QR_CARD");
		cardQRCode.setExpire_seconds(1800);

		CardActionInfo actionInfo = new CardActionInfo();
		CardInActionInfo inActionInfo = new CardInActionInfo();
		inActionInfo.setCard_id(MEMBER_CARD_ID);
		actionInfo.setCard(inActionInfo);

		cardQRCode.setAction_info(actionInfo);

		return cardQRCode;
	}

	public static JSONObject createMenu() throws ParseException, IOException {
		String menu = JSONObject.fromObject(initMyMenu()).toString();
		System.out.println(menu);

		// int result = 0;
		String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", ACCESS_TOKEN);
		JSONObject jsonObject = doPostStr(url, menu);
		// if (jsonObject != null) {
		// result = jsonObject.getInt("errcode");
		// }
		return jsonObject;
	}

	public static JSONObject queryMenu(String token) throws ParseException, IOException {
		String url = QUERY_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		return jsonObject;
	}

	public static JSONObject deleteMenu(String token) throws ParseException, IOException {
		String url = DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		return jsonObject;
	}

	/**
	 * 初始化图文消息
	 */
	private static Articles initArcticle() {
		Articles articles = new Articles();
		Article article = new Article();
		article.setTitle("22本值得读的好书 ");
		article.setThumb_media_id(ETERNAL_THUMB_MEDIA_ID);
		article.setAuthor("madison");
		article.setDigest("22本值得收藏的好书");
		article.setShow_cover_pic("1");
		StringBuffer sb = new StringBuffer();
		sb.append("No.1 《无声告白》" + "类型：社会小说    伍绮诗（著）").append("<img alt=\"嘿嘿\" src=\"").append(NEWS_IMAGE_URL)
				.append("\"/>")
				.append("莉迪亚死了，可他们还不知道。" + "莉迪亚是家中老二，李先生和李太太的掌上明珠，她遗传了母亲的蓝眼睛和父亲的黑头发。父母深信，"
						+ "莉迪亚一定能实现他们无法实现的梦想。莉迪亚的尸体被发现后，她的父亲内疚不已，" + "母亲则一心报复。莉迪亚的哥哥觉得，隔壁的坏小子铁定脱不了关系，"
						+ "只有莉迪亚的妹妹看得一清二楚，而且，她很可能是唯一知道真相的人……")
				.append("No.2 《岛上书店》" + "类型：情感小说   加布瑞埃拉·泽文（著）").append("<img alt=\"嘿嘿\" src=\"").append(NEWS_IMAGE_URL)
				.append("\"/>")
				.append("A．J．费克里，人近中年，在一座与世隔绝的小岛上，经营一家书店。命运从未眷顾过他，爱妻去世，书店危机，就连唯一值钱的宝贝也遭窃。他的人生陷入僵局，他的内心沦为荒岛。" +

						"就在此时，一个神秘的包袱出现在书店中，意外地拯救了陷于孤独绝境中的A．J．，成为了连接他和小姨子伊斯梅、警长兰比亚斯、出版社女业务员阿米莉娅之间的纽带，为他的生活带来了转机。" +

						"小岛上的几个生命紧紧相依，走出了人生的困境，而所有对书和生活的热爱都周而复始，愈加汹涌。");
		article.setContent(sb.toString());
		article.setContent_source_url("http://mp.weixin.qq.com/s/rmV8QDgjrljOTjCfYZFHyg");
		articles.setArticles(new Article[] { article });
		return articles;
	}

	/**
	 * 上传图文消息
	 * 
	 * @param token
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject uploadArticle(String token) throws ParseException, IOException {
		String articles = JSONObject.fromObject(initArcticle()).toString();
		System.out.println("articles：" + articles);
		String url = ADD_NEWS_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostStr(url, articles);

		return jsonObject;
	}

	public static String translate(String source) throws ParseException, IOException {
		String url = "http://api.fanyi.baidu.com/public/2.0/translate/dict/simple?client_id=jNg0LPSBe691Il0CG5MwDupw&q=KEYWORD&from=auto&to=auto";
		url = url.replace("KEYWORD", URLEncoder.encode(source, "UTF-8"));
		JSONObject jsonObject = doGetStr(url);
		String errno = jsonObject.getString("errno");
		Object obj = jsonObject.get("data");
		StringBuffer dst = new StringBuffer();
		if ("0".equals(errno) && !"[]".equals(obj.toString())) {
			TransResult transResult = (TransResult) JSONObject.toBean(jsonObject, TransResult.class);
			Data data = transResult.getData();
			Symbols symbols = data.getSymbols()[0];
			String phzh = symbols.getPh_zh() == null ? "" : "中文拼音：" + symbols.getPh_zh() + "\n";
			String phen = symbols.getPh_en() == null ? "" : "英式英标：" + symbols.getPh_en() + "\n";
			String pham = symbols.getPh_am() == null ? "" : "美式英标：" + symbols.getPh_am() + "\n";
			dst.append(phzh + phen + pham);

			Parts[] parts = symbols.getParts();
			String pat = null;
			for (Parts part : parts) {
				pat = (part.getPart() != null && !"".equals(part.getPart())) ? "[" + part.getPart() + "]" : "";
				String[] means = part.getMeans();
				dst.append(pat);
				for (String mean : means) {
					dst.append(mean + ";");
				}
			}
		} else {
			dst.append(translateFull(source));
		}
		return dst.toString();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String translateFull(String source) throws ParseException, IOException {
		String url = "http://openapi.baidu.com/public/2.0/bmt/translate?client_id=jNg0LPSBe691Il0CG5MwDupw&q=KEYWORD&from=auto&to=auto";
		url = url.replace("KEYWORD", URLEncoder.encode(source, "UTF-8"));
		JSONObject jsonObject = doGetStr(url);
		StringBuffer dst = new StringBuffer();
		List<Map> list = (List<Map>) jsonObject.get("trans_result");
		for (Map map : list) {
			dst.append(map.get("dst"));
		}
		return dst.toString();
	}

	/**
	 * 创建卡券
	 * 
	 * @param token
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject createCard() throws ParseException, IOException {
		JsonConfig jsonConfig = new JsonConfig();
		// jsonConfig.setExcludes(new String[] { "advanced_info" });

		JSONObject jsonObject = JSONObject.fromObject(initCard(), jsonConfig);
		String json = jsonObject.toString().replace("card_abstract", "abstract");
		System.out.println(json);
		String createCradUrl = CREATE_CARD_URL.replace("ACCESS_TOKEN", ACCESS_TOKEN);
		JSONObject cardJSONObject = doPostStr(createCradUrl, json);
		return cardJSONObject;
	}

	/**
	 * 發送卡券投放请求
	 * 
	 * @param token
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject qrcodeCard() throws ParseException, IOException {
		JSONObject jsonObject = JSONObject.fromObject(initQRCodeCard());
		String json = jsonObject.toString();
		System.out.println(json);

		String qrcodeUrl = QRCODE_CARD_URL.replace("TOKEN", ACCESS_TOKEN);
		JSONObject qrcodeCard = doPostStr(qrcodeUrl, json);
		return qrcodeCard;
	}

	public static JSONObject SendKFNewsMsg_south711() throws ParseException, IOException {
		// String strOpenID = "oGT8Zt-oModKeE9w9fyFNNFRVgu0"; //Tei
		// String strOpenID = "oMSB6uDFJHOy4tl6jZDolrROiBtk"; //Joyce
		// String strOpenID = "oMSB6uL53O-EXzYAi5A-DA76fP9o"; //Joyce
		// String strOpenID = "oGT8Zt1tc2GGK4Ll0PhguxROMQQI"; //Eric
		// String strOpenID = "oGT8Zt67_jP3vCCnICPGW144bo1o"; //pino
		// String strOpenID = "oGT8Zt9hPamfATXMUJQl0PryeMc8"; //pino
		// String strOpenID = "oMSB6uMp-PTKdFrZoRmNyX4-AWNg"; //danny
		String strOpenID = "oGT8Ztz5hJK42rcQwhg8xijBDqLE"; // danny
//		String strWXToken = "nd-DpBo2KClp0YWrccXPCtPp_9mDdwqHf0-4q7gOqkomzeraZaGuz_jTbbOkLrXePrZQKHwi4TCuWSftKUZky5p4weRv8bOSSzD82QBk7RksegONvrMiYq-2IHNfMEN_MHIdAEAPKL";
		String strTitle = "支付确认";
		String strAds = "“二零一七”春来惠至[广告]";
		String strContent = "付款金额：15.00 元\r\n商品名称：微信支付\r\n商户名称：卡购商城南京西路店\r\n交易订单：4005282001201704143563642788\r\n交易时间：2017-05-11 17:50:12\r\n\r\n"
				+ strAds;
		// String strURL = "https://www.beijing-hyundai.com.cn";
		// String strPicURL =
		// "https://www.beijing-hyundai.com.cn/Uploads/thumb/470_218/Uploads_image_20170303_20170303090155_58438.jpg";
		String strPicURL = "https://qa1-eng.kargotest.com/CHolder/control/ad_open?kcid=000530445814&turl=aHR0cHM6Ly9xYTEtZW5nLmthcmdvdGVzdC5jb20vQ0hvbGRlci9yZXNvdXJjZXMvaW1nL2R1bW15X2ltZzMuanBn&time="
				+ new Date().getTime();
		String strURL = "https://qa1-eng.kargotest.com/CHolder/control/ad_click?kcid=000530445814&turl=aHR0cDovL3d3dy5rYXJnb2NhcmQuY29tLw==&time="
				+ new Date().getTime();

		String strMsg = "{\"touser\":\"" + strOpenID + "\",\"msgtype\":\"news\",\"news\":{\"articles\": [{\"title\":\""
				+ strTitle + "\",\"description\":\"" + strContent + "\",\"url\":\"" + strURL + "\",\"picurl\":\""
				+ strPicURL + "\"}]}}";

//		strWXToken = "6gcHEDFbr3LOqMZssDeLrmqlXj6iFyokQsiIfja-lkAgCCfc1b_FXXrO9RIC6oMOyzYMNPAk8J3rmy16YhiaWVcan2Bdoxhy7l2q4SW7hI7VQCrVWeU3xUvxg99-Zq5BJOMbABAUZX";
		strMsg = "{\"touser\":\"oY5mJw5d7G78pHVkXrwXJVHkDr_Y\",\"msgtype\":\"news\",\"news\":{\"articles\":[{\"title\":\"支付确认\",\"description\":\"付款金额：0.01 元\\n商品名称：微信支付\\n商户名称：jiasiduo 测试商户\\n交易订单：4000822001201706074680844774\\n交易时间：2017-06-07 13:29:44\\n\\n“二零一七”春来惠至[广告]\",\"url\":\"www.baidu.com\",\"picurl\":\"http://qa1-eng.kargotest.com:81/CHolder/control/ad_open?kcid=000530459612&turl=aHR0cDovL3Rlc3Quc2Fhc2JwLnN0b3JtYWQuY24vZGlzdC91cGxvYWQvYWQvMjAxNzA2MDYvMTU5MzZhMjBmMjcwYzguanBn&time=1496813386381\"}]}}";

		return doPostStr("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + ACCESS_TOKEN,
					strMsg);
	}

}
