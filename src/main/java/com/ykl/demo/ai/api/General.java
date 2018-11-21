package com.ykl.demo.ai.api;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.util.Base64Util;
import com.ykl.demo.utils.FileUtil;
import com.ykl.demo.utils.HttpUtil;

public class General {
	 /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     * 	filePath 本地图片路径
     */
	public static String getText(String accessToken, String filePath) {
		// 通用识别url
		String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";
	
		String result = null;
		try {
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
			result = HttpUtil.post(otherHost, accessToken, params);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<String> getImgText(String accessToken, MultipartFile file) throws Exception {
		String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";
		String imgStr = Base64Util.encode(file.getBytes());
		String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
		String result = HttpUtil.post(otherHost, accessToken, params);
		System.out.println(result);
		JSONObject data = JSONObject.parseObject(result);
		JSONArray array = data.getJSONArray("words_result");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < array.size(); i++) {
			JSONObject d = (JSONObject) array.get(i);
			list.add(d.getString("words"));
		}
		return list;
	}
}
