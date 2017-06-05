package com.weimob.arch.demo.model.response;

import java.io.Serializable;
import java.util.List;

/**
 * 根据性别查找架构部的小伙伴 出参
 * 
 * @author nengfei.liu
 * @date 2017年5月27日 下午5:06:58
 * @version 1.0
 */
public class FindArchPartnerBySexResponseVo implements Serializable{

	private static final long serialVersionUID = 1396575448126260826L;

	/**
	 * 伙伴
	 */
	private List<PartnerBaseInfoVo> partnerList;

	public List<PartnerBaseInfoVo> getPartnerList() {
		return partnerList;
	}

	public void setPartnerList(List<PartnerBaseInfoVo> partnerList) {
		this.partnerList = partnerList;
	}

}
