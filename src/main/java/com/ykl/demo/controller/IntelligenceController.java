package com.ykl.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ykl.demo.ai.api.FaceDetect;
import com.ykl.demo.ai.api.FaceMatch;
import com.ykl.demo.ai.api.General;
import com.ykl.demo.common.ResultCode;
import com.ykl.demo.common.ResultData;
import com.ykl.demo.config.BaiDuConfig;
import com.ykl.demo.utils.AuthService;

/**
 * 智能控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/intell")
public class IntelligenceController {
	/**
	 * 获取人脸信息
	 * @return
	 */
	@GetMapping("/getFaceInfo")
	public String getFaceInfo() {
		String accessToken = AuthService.getAuth(BaiDuConfig.AK, BaiDuConfig.SK);
		return FaceDetect.detect(accessToken);
	}
	/**
	 * 两张脸相似度
	 * @return
	 */
	@GetMapping("/matchFace")
	public String matchFace() {
		String accessToken = AuthService.getAuth(BaiDuConfig.AK, BaiDuConfig.SK);
		return FaceMatch.match(accessToken);
	}
	/**
	 * 提取图片中的文字信息
	 * @return
	 */
	@PostMapping("/getText")
	public ResultData getText(@RequestParam("file") MultipartFile file) {
		String accessToken = AuthService.getAuth(BaiDuConfig.TEXT_AK, BaiDuConfig.TEXT_SK);
		try {
			List<String> list = General.getImgText(accessToken, file);
			return ResultData.success(list);
		} catch (Exception e) {
			return ResultData.warn(ResultCode.INTERNAL_SERVER_ERROR);
		}
	}
}
