package com.weimob.arch.demo.service.base;

import java.util.List;

import com.weimob.arch.demo.model.Partner;

public interface PartnerBaseService {

	Partner getPartnerById(Long id);
	
	List<Partner> findPartnerListBySex(Integer sex);
}
