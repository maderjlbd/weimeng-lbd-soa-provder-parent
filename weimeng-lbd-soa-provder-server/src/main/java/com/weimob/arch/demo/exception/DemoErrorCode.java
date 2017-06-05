package com.weimob.arch.demo.exception;

/**
 * 错误码
 * 
 * @author nengfei.liu
 * @date 2017年5月27日 下午2:26:30
 * @version 1.0
 */
public enum DemoErrorCode {

	/*********************** 公共返回码 *********************/
	SUCCESS("000000", "处理成功"), 
	FAIL("999999", "处理失败"),
	
	REQUEST_PARAM_IS_NULL("100001","请求参数不能为空"),
	REQUEST_SEX_IS_NULL_OR_1_2("100002","请求参数要么为空，要么为1或2","你太重口味了，架构部可没有这种人"),

	QUERY_PHONE_ZONE_ERROR("200001","查询号码归属地失败"),
	PHONE_ZONE_FORMAT_ERROR("200002","号码归属地格式有误"),
	;

	private String errorCode;

	private String errorMsg;
	
	private String returnMsg;
	
	private DemoErrorCode(String errorCode,String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.returnMsg = errorMsg;
	}
	
	private DemoErrorCode(String errorCode,String errorMsg, String returnMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.returnMsg = returnMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getReturnMsg() {
		return (returnMsg==null || returnMsg.isEmpty()) ? errorMsg : returnMsg;
	}
	
	public static DemoErrorCode getDemoErrorCode(String errorCode){
		for (DemoErrorCode demoErrorCode : DemoErrorCode.values()) {
			if(demoErrorCode.getErrorCode().equals(errorCode)){
				return demoErrorCode;
			}
		}
		return null;
	}
}