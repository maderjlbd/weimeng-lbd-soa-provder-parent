package com.weimob.arch.demo.dao;

import java.util.List;

import com.weimob.arch.demo.model.Partner;

public interface PartnerDao {

	Partner getPartnerById(Long id);

	List<Partner> findPartnerListBySex(Integer sex);
}
