package com.imooc.test;

import com.imooc.util.WeixinUtil;

import net.sf.json.JSONObject;



public class WeixinTest {
	public static void main(String[] args) {
		try {
//			AccessToken token = WeixinUtil.getAccessToken();
//			System.out.println("票据:");
//			System.out.println(token.getToken());
//			System.out.println("有效时间:"+token.getExpiresIn());
			
			
//			String imagePath = "f:/Resource/image.jpg";
//			String thumbPaht = "f:/Resource/thumb.jpg";
//			String voicePath = "f:/Resource/voice.mp3";
//			String videoPath = "f:/Resource/haha.mp4";
//			String imageMediaId = WeixinUtil.upload(imagePath,WeixinUtil.UPLOAD_IMG_URL, WeixinUtil.ACCESS_TOKEN, "image");
//			System.out.println("imageMediaId：");
//			System.out.println(imageMediaId);
//			String thumbMediaId = WeixinUtil.upload(imagePath,WeixinUtil.UPLOAD_IMG_URL, WeixinUtil.ACCESS_TOKEN, "thumb");
//			System.out.println("thumbMediaId：");
//			System.out.println(thumbMediaId);
//			String voiceMediaId = WeixinUtil.upload(voicePath,WeixinUtil.UPLOAD_IMG_URL, WeixinUtil.ACCESS_TOKEN, "voice");
//			System.out.println("voiceMediaId："); 
//			System.out.println(voiceMediaId);
//			String videoMediaId = WeixinUtil.upload(videoPath,WeixinUtil.UPLOAD_IMG_URL, WeixinUtil.ACCESS_TOKEN, "video");
//			System.out.println("videoMediaId：");
//			System.out.println(videoMediaId);
			
			//上传永久素材
			//永久图片素材
//			String eternalImageMediaId = WeixinUtil.upload(imagePath,WeixinUtil.ADD_MATERIAL_URL, WeixinUtil.ACCESS_TOKEN, "image");
//			System.out.println("eternalImageMediaId:");
//			System.out.println(eternalImageMediaId);
			//永久缩略图素材
//			String eternalthumbMediaId = WeixinUtil.upload(thumbPaht,WeixinUtil.ADD_MATERIAL_URL, WeixinUtil.ACCESS_TOKEN, "thumb");
//			System.out.println("eternalthumbMediaId:");
//			System.out.println(eternalthumbMediaId);
			//永久语音素材
//			String eternalVoiceMediaId = WeixinUtil.upload(voicePath,WeixinUtil.ADD_MATERIAL_URL, WeixinUtil.ACCESS_TOKEN, "voice");
//			System.out.println("eternalVoiceMediaId:");
//			System.out.println(eternalVoiceMediaId);
			//永久视频素材
//			String eternalVideoMediaId = WeixinUtil.upload(videoPath,WeixinUtil.ADD_MATERIAL_URL, WeixinUtil.ACCESS_TOKEN, "video");
//			System.out.println("eternalVideoMediaId:");
//			System.out.println(eternalVideoMediaId);
			//永久图文素材
//			JSONObject eternalNews = WeixinUtil.uploadArticle(WeixinUtil.ACCESS_TOKEN);
//			System.out.println("eternalNews:");
//			System.out.println(eternalNews.toString());
			
	
			
//			int result = WeixinUtil.createMenu(WeixinUtil.ACCESS_TOKEN);
//			if(result == 0){
//				System.out.println("创建菜单成功");
//			}else{
//				System.out.println("错误码:"+result);
//			}
			
			//创建菜单
			JSONObject jsonObject = WeixinUtil.createMenu(WeixinUtil.ACCESS_TOKEN);
			System.out.println(jsonObject.toString());
			String videoPath = "f:/Resource/haha.mp4";
//			String imageMediaId = WeixinUtil.upload(imagePath,WeixinUtil.UPLOAD_IMG_URL, WeixinUtil.ACCESS_TOKEN, "image");
//			System.out.println("imageMediaId：");
//			System.out.println(imageMediaId);
//			String thumbMediaId = WeixinUtil.upload(imagePath,WeixinUtil.UPLOAD_IMG_URL, WeixinUtil.ACCESS_TOKEN, "thumb");
//			System.out.println("thumbMediaId：");
//			System.out.println(thumbMediaId);
//			String voiceMediaId = WeixinUtil.upload(voicePath,WeixinUtil.UPLOAD_IMG_URL, WeixinUtil.ACCESS_TOKEN, "voice");
//			System.out.println("voiceMediaId："); 
//			System.out.println(voiceMediaId);
//			String videoMediaId = WeixinUtil.upload(videoPath,WeixinUtil.UPLOAD_IMG_URL, WeixinUtil.ACCESS_TOKEN, "video");
//			System.out.println("videoMediaId：");
//			System.out.println(videoMediaId);
			
			//上传永久素材
			//永久图片素材
//			String eternalImageMediaId = WeixinUtil.upload(imagePath,WeixinUtil.ADD_MATERIAL_URL, WeixinUtil.ACCESS_TOKEN, "image");
//			System.out.println("eternalImageMediaId:");
//			System.out.println(eternalImageMediaId);
			//永久缩略图素材
//			String eternalthumbMediaId = WeixinUtil.upload(thumbPaht,WeixinUtil.ADD_MATERIAL_URL, WeixinUtil.ACCESS_TOKEN, "thumb");
//			System.out.println("eternalthumbMediaId:");
//			System.out.println(eternalthumbMediaId);
			//永久语音素材
//			String eternalVoiceMediaId = WeixinUtil.upload(voicePath,WeixinUtil.ADD_MATERIAL_URL, WeixinUtil.ACCESS_TOKEN, "voice");
//			System.out.println("eternalVoiceMediaId:");
//			System.out.println(eternalVoiceMediaId);
			//永久视频素材
//			String eternalVideoMediaId = WeixinUtil.upload(videoPath,WeixinUtil.ADD_MATERIAL_URL, WeixinUtil.ACCESS_TOKEN, "video");
//			System.out.println("eternalVideoMediaId:");
//			System.out.println(eternalVideoMediaId);
			//永久图文素材
//			JSONObject eternalNews = WeixinUtil.uploadArticle(WeixinUtil.ACCESS_TOKEN);
//			System.out.println("eternalNews:");
//			System.out.println(eternalNews.toString());
			
	
			
//			int result = WeixinUtil.createMenu(WeixinUtil.ACCESS_TOKEN);
//			if(result == 0){
//				System.out.println("创建菜单成功");
//			}else{
//				System.out.println("错误码:"+result);
//			}
			
			//创建菜单
//			JSONObject jsonObject = WeixinUtil.createMenu(WeixinUtil.ACCESS_TOKEN);
//			System.out.println(jsonObject.toString());
			
//			JSONObject jsonObject = WeixinUtil.queryMenu(WeixinUtil.ACCESS_TOKEN);
//			System.out.println(jsonObject.toString());
			
			
//			JSONObject jsonObject = WeixinUtil.deleteMenu(WeixinUtil.ACCESS_TOKEN);
//			System.out.println(jsonObject.toString());
			
			
//			String result = WeixinUtil.translate("あなたのことが好きです");
//			String result = WeixinUtil.translate("my name is laobi");
//			String result = WeixinUtil.translateFull("");
//			System.out.println(result);
			
			
/*			System.out.println(CheckUtil.getMD5("imooc security md"));
			System.out.println(MD5.md5("imooc security md"));*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
