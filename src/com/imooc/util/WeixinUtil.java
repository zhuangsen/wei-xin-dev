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
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

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

import com.imooc.menu.Button;
import com.imooc.menu.ClickButton;
import com.imooc.menu.MediaButton;
import com.imooc.menu.Menu;
import com.imooc.menu.MiniProgramButton;
import com.imooc.menu.ViewButton;
import com.imooc.po.AccessToken;
import com.imooc.po.Article;
import com.imooc.po.Articles;
import com.imooc.trans.Data;
import com.imooc.trans.Parts;
import com.imooc.trans.Symbols;
import com.imooc.trans.TransResult;

/**
 * 微信工具类
 *
 */
public class WeixinUtil {
	public static final String APPID = "wx556e5b2e4d4b827a";
	public static final String APPSECRET = "dd8ee32598397b58b0f34881c3bc7079";

	public static final String TEST_APPID = "wx73834ad5aa2dfaa7";
	public static final String TEST_APPSECRET = "1f6301ee7a66d882e6afeac6fe07237e";

	public static final String ACCESS_TOKEN = "TClVguNxwkv-xuMV1YDeWvXn8NUySx2Bef4wtEHpp3okYgavIxhvt-yeH-wt8WrWEFCQupmx9EtfPfrBLsIVI3-5mT6V-3A80FfFhAHIn-mRhO9m6HFoJah3hubqF57QKHXhAHAOLB";
	public static final String IMAGE_MEDIA_ID = "cO8ZMtvh2aaPpLMZnUWRwi0yxsYehf7dKUt6C4aOgWTp1-vgK3f6Bpo-7Qq3QLyN";
	public static final String THUMB_MEDIA_ID = "mRDvVozWpj-fcrM00MjZnClQsE7Ez6G-YXcprJ4POInrczFCadMBqbfLWjI0y6VK";
	public static final String VOICE_MEDIA_ID = "3nMtF8o0A9lsZJn9Wke04nj8Tdm6mJOqFExlzLNomYZ_xZ9uN8xLrGVuAT3kuDWI";
	public static final String VIDEO_MEDIA_ID = "D9ZH8lm5Rp0qEHgISwFcnDozDESbCPlwHn-uO5tiddTo2uImrEK8134EUvIDDkmI";

	public static final String ETERNAL_IMAGE_MEDIA_ID = "hxPHGVxpzKRlb05H0LrfWiXBrxz2t0RvDX7IyBRwj8o";
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
	public static final String NEWS_IMAGE_URL = "http://mmbiz.qpic.cn/mmbiz_jpg/JNF4MLsWR7ftHxTB9bSje3EKeVGZ9u0dnsoNURd6ibOXgqUSYWyU1mcTStL93ic4IrAOTTso2NbQVUEboMxFwTbA/0";

	private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	private static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

	private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	public static final String PROJECT_LINK = "http://zhuangsen.tunnel.qydev.com/wei-xin";
	public static final String RESOURCES_PATH = "/resources/music.mp3";

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
	public static void upload(String filePath, String uploadUrl, String accessToken, String type)
			throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {

		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}

		String url = uploadUrl.replace("ACCESS_TOKEN", accessToken);
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
		tupian.setMedia_id(ETERNAL_IMAGE_MEDIA_ID);
		MediaButton tuwen = new MediaButton();
		tuwen.setName("图文消息");
		tuwen.setType("media_id");
		tuwen.setMedia_id(ETERNAL_NEWS_MEDIA_ID);
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

	public static JSONObject createMenu(String token) throws ParseException, IOException {
		String menu = JSONObject.fromObject(initMyMenu()).toString();
		System.out.println(menu);

		// int result = 0;
		String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
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
}
