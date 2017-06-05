package com.weimob.arch.demo.model;

/**
 * 小伙伴的基本信息
 * 
 * @author nengfei.liu
 * @date 2017年5月27日 下午5:10:27
 * @version 1.0
 */
public class Partner {

	/**
	 * 伙伴id
	 */
	private Long id;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 照片
	 */
	private String image;
	
	/**
	 * 性别
	 */
	private Integer sex;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

}
