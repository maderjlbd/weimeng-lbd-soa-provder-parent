package com.weimob.arch.demo.model.request;

import java.io.Serializable;

/**
 * 根据性别查找架构部的伙伴入参
 * 
 * @author nengfei.liu
 * @date 2017年5月27日 下午4:57:26
 * @version 1.0
 */
public class FindArchPartnerBySexRequestVo implements Serializable{

	private static final long serialVersionUID = -9106401817451991319L;

	/**
	 * 性别:1男, 2女
	 */
	private Integer sex;

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
}
