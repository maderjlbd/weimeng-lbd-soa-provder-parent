package com.weimob.arch.demo.service.third.impl;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.weimob.arch.demo.exception.DemoBizException;
import com.weimob.arch.demo.exception.DemoErrorCode;
import com.weimob.arch.demo.service.third.PhoneZoneService;
import com.weimob.arch.demo.service.third.model.PhoneZone;
import com.weimob.http.client.model.HttpResponseResult;
import com.weimob.http.client.service.AbstractHttpService;

public class PhoneZoneServiceImpl extends AbstractHttpService implements PhoneZoneService{

	private String baseUrl;
	
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	private enum PhoneZoneServicePath{
		
		GET_PHONE_ZONE("/cc/json/mobile_tel_segment.htm","获取号码归属地");
		
		private PhoneZoneServicePath(String path, String desc) {
			this.path = path;
			this.desc = desc;
		}

		private String path;
		
		private String desc;

		public String getPath() {
			return path;
		}

		public String getDesc() {
			return desc;
		}
		
	}
	
	@Override
	public PhoneZone getPhoneZone(String phoneNum) {
		//组装入参
		Map<String, Object> param = new HashMap<>();
		param.put("tel", phoneNum);
		
		//远程调用
		HttpResponseResult<String> result = getStrByGetParameters(
				baseUrl + PhoneZoneServicePath.GET_PHONE_ZONE.getPath(), param);
		
		//出参校验
		validatePhoneZone(result);
		
		//返回出参
		String response = result.getResponseVo();
		return JSON.parseObject(response.substring(response.indexOf("=")+1), PhoneZone.class);
	}

	private void validatePhoneZone(HttpResponseResult<String> result) {
		if(result == null || result.getResponseVo()==null){
			throw new DemoBizException(DemoErrorCode.QUERY_PHONE_ZONE_ERROR);
		}
		if(!result.getResponseVo().contains("=")){
			throw new DemoBizException(DemoErrorCode.PHONE_ZONE_FORMAT_ERROR);
		}
	}

}
