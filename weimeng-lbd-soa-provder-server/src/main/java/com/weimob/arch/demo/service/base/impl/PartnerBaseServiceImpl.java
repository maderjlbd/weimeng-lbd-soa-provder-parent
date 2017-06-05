package com.weimob.arch.demo.service.base.impl;

import java.util.List;

import com.weimob.arch.demo.dao.PartnerDao;
import com.weimob.arch.demo.model.Partner;
import com.weimob.arch.demo.service.base.PartnerBaseService;

public class PartnerBaseServiceImpl implements PartnerBaseService{

	private PartnerDao partnerDao;
	
	public void setPartnerDao(PartnerDao partnerDao) {
		this.partnerDao = partnerDao;
	}

	@Override
	public Partner getPartnerById(Long id) {
		return partnerDao.getPartnerById(id);
	}

	@Override
	public List<Partner> findPartnerListBySex(Integer sex) {
		return partnerDao.findPartnerListBySex(sex);
	}

}
