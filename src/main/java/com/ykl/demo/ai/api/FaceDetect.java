package com.ykl.demo.ai.api;

import java.util.HashMap;
import java.util.Map;

import com.ykl.demo.utils.HttpUtil;

import net.sf.json.JSONObject;
/**
 * 获取人脸信息
 * @author 杨坤量
 *
 */
public class FaceDetect {
	/**
	    * 重要提示代码中所需工具类
	    * FileUtil,Base64Util,HttpUtil,GsonUtils请从
	    * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	    * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	    * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	    * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
	    * 下载
	    */
	    public static String detect(String accessToken) {
	        // 请求url
	        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
	        try {
	            Map<String, Object> map = new HashMap<>();
	            map.put("image", "https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=4a67fa58cafcc3ceb4c0ce35aa7eb1b5/d62a6059252dd42a254377d1013b5bb5c9eab805.jpg");
//	            map.put("face_field", "faceshape,facetype");
	            map.put("image_type", "URL");
	            map.put("max_face_num", 10);

	            String param = JSONObject.fromObject(map).toString();

	            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
//	            String accessToken = "24.044ca9dc86e42d10f423554a1b3601c5.2592000.1536454056.282335-10115141";

	            String result = HttpUtil.post(url, accessToken, "application/json", param);
	            System.out.println(result);
	            return result;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	/*    public static void main(String[] args) {
	    	String accessToken = AuthService.getAuth();
	        FaceDetect.detect(accessToken);
	    }*/
}
