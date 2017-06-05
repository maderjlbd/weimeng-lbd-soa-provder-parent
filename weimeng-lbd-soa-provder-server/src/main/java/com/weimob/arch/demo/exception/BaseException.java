package com.weimob.arch.demo.exception;

import com.dianping.cat.exception.UserDefinedCatExceptionName;

/**
 * 基础异常类
 * 
 * @author nengfei.liu
 * @date 2017年5月27日 下午2:23:32
 * @version 1.0
 */
public class BaseException extends RuntimeException implements UserDefinedCatExceptionName{
	
	private static final long serialVersionUID = -9187378028155695395L;
	
	/**
	 * 错误码，如"000000"
	 */
	private String errorCode;
	
	/**
	 * 错误描述,如"处理成功"
	 */
	private String errorMsg;
	
	public BaseException(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public BaseException(String errorCode, String errorMsg, Throwable t) {
		super(t);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString(){
		return super.toString()+" [errorCode = " + errorCode + "，errorMsg=" + errorMsg + "]";
	}

	@Override
	public String getUserDefinedExceptionName() {
		return errorCode+"-"+errorMsg;
	}

}
