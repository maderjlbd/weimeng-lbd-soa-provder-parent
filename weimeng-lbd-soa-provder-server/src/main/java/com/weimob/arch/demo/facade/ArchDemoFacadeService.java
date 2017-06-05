package com.weimob.arch.demo.facade;

import java.util.Arrays;
import java.util.List;

import com.weimob.arch.demo.exception.DemoBizException;
import com.weimob.arch.demo.exception.DemoErrorCode;
import com.weimob.arch.demo.model.Partner;
import com.weimob.arch.demo.model.request.FindArchPartnerBySexRequestVo;
import com.weimob.arch.demo.model.response.FindArchPartnerBySexResponseVo;
import com.weimob.arch.demo.model.response.PartnerBaseInfoVo;
import com.weimob.arch.demo.service.base.PartnerBaseService;
import com.weimob.arch.demo.utils.DemoUtil;

public class ArchDemoFacadeService {

	private PartnerBaseService partnerBaseService;
	
	public void setPartnerBaseService(PartnerBaseService partnerBaseService) {
		this.partnerBaseService = partnerBaseService;
	}

	/**
	 * 根据性别查询架构部小伙伴
	 * 
	 * @author nengfei.liu
	 * @param requestVo
	 * @return
	 */
	public FindArchPartnerBySexResponseVo findArchPartnerBySex(FindArchPartnerBySexRequestVo requestVo){
		//参数校验
		validateFindArchPartnerBySexRequestVo(requestVo);
		
		//查询架构部小伙伴
		List<Partner> partnerList = partnerBaseService.findPartnerListBySex(requestVo.getSex());
		
		//构造出参并返回
		FindArchPartnerBySexResponseVo responseVo = new FindArchPartnerBySexResponseVo();
		responseVo.setPartnerList(DemoUtil.copyList(partnerList, PartnerBaseInfoVo.class));
		
		return responseVo;
	}

	private void validateFindArchPartnerBySexRequestVo(FindArchPartnerBySexRequestVo requestVo) {
		if(requestVo == null){
			throw new DemoBizException(DemoErrorCode.REQUEST_PARAM_IS_NULL);
		}
		if(requestVo.getSex()!=null && Arrays.binarySearch(new int[]{1,2}, requestVo.getSex()) < 0){
			throw new DemoBizException(DemoErrorCode.REQUEST_SEX_IS_NULL_OR_1_2);
		}
	}
}
