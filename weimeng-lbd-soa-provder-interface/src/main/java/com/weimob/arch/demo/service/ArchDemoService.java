package com.weimob.arch.demo.service;

import com.weimob.arch.demo.model.DemoCommonErrorVo;
import com.weimob.arch.demo.model.request.FindArchPartnerBySexRequestVo;
import com.weimob.arch.demo.model.response.FindArchPartnerBySexResponseVo;
import com.weimob.soa.common.response.SoaResponse;

/**
 * demo服务
 * 
 * @author nengfei.liu
 * @date 2017年5月27日 下午4:57:10
 * @version 1.0
 */
public interface ArchDemoService {

	/**
	 * 根据性别查找架构部的伙伴
	 * 
	 * @param requestVo
	 * @return
	 */
	SoaResponse<FindArchPartnerBySexResponseVo, DemoCommonErrorVo> findArchPartnerBySex(FindArchPartnerBySexRequestVo requestVo);
}
