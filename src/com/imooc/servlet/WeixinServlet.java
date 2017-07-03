package com.imooc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.imooc.util.CheckUtil;
import com.imooc.util.MessageUtil;
import com.imooc.util.WeixinUtil;

public class WeixinServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 接入验证
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");

		PrintWriter out = resp.getWriter();
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
	}

	/**
	 * 消息的接收与响应
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			Map<String, String> map = MessageUtil.xmlToMap(req);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
//			String msgId = map.get("MsgId");

			String message = null;
			if (MessageUtil.MESSAGE_TEXT.equals(msgType)) {
				System.out.println("消息类型信息:"+map);
				if ("1".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
				} else if ("2".equals(content)) {
					message = MessageUtil.initNewsMessage(toUserName, fromUserName);
				} else if ("3".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.threeMenu());
				} else if ("4".equals(content)) {
					message = MessageUtil.initImageMessage(toUserName, fromUserName);
				} else if ("5".equals(content)) {
					message = MessageUtil.initVoiceMessage(toUserName, fromUserName);
				} else if ("6".equals(content)) {
					message = MessageUtil.initVideoMessage(toUserName, fromUserName);
				} else if ("7".equals(content)) {
					message = MessageUtil.initMusicMessage(toUserName, fromUserName);
				} else if (content.startsWith("翻译")) {
					String word = content.replaceAll("^翻译", "").trim();
					if ("".equals(word)) {
						message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.threeMenu());
					} else {
						message = MessageUtil.initText(toUserName, fromUserName, WeixinUtil.translate(word));
					}
				} else {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}
			} else if (MessageUtil.MESSAGE_EVNET.equals(msgType)) {
				System.out.println("event信息:"+map);
				String eventType = map.get("Event");
				if (MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				} else if (MessageUtil.MESSAGE_CLICK.equals(eventType)) {
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				} else if (MessageUtil.MESSAGE_VIEW.equals(eventType)) {
					String url = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, url);
				} else if (MessageUtil.MESSAGE_SCANCODE_PUSH.equals(eventType)) {
					String key = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, key);
				} else if (MessageUtil.MESSAGE_SCANCODE_WAITMSG.equals(eventType)) {
					String key = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, key);
				}
			} else if (MessageUtil.MESSAGE_LOCATION.equals(msgType)) {
				System.out.println("地理位置信息:"+map);
				String label = map.get("Label");
				message = MessageUtil.initText(toUserName, fromUserName, label);
			}

			System.out.println(message);

			out.print(message);
		} catch (

		DocumentException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
