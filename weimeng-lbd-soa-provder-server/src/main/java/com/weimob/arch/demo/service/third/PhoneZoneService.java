package com.weimob.arch.demo.service.third;

import com.weimob.arch.demo.service.third.model.PhoneZone;

public interface PhoneZoneService {

	/**
	 * 获取号码归属地
	 * 
	 * @author nengfei.liu
	 * @param phoneNum
	 * @return
	 */
	PhoneZone getPhoneZone(String phoneNum);
}
