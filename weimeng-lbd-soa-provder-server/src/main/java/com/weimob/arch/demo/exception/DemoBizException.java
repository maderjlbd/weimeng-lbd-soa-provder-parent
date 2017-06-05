package com.weimob.arch.demo.exception;

/**
 * 业务异常类
 * 
 * @author nengfei.liu
 * @date 2017年5月27日 下午2:25:45
 * @version 1.0
 */
public class DemoBizException extends BaseException {
	
	private static final long serialVersionUID = 8948576917258987274L;

	private DemoErrorCode demoErrorCode;
	
	private String bizInfo;
	
	public DemoBizException(DemoErrorCode demoErrorCode) {
		super(demoErrorCode.getErrorCode(), demoErrorCode.getErrorMsg());
		this.demoErrorCode = demoErrorCode;
	}
	
	public DemoBizException(DemoErrorCode demoErrorCode,Throwable t) {
		super(demoErrorCode.getErrorCode(), demoErrorCode.getErrorMsg(),t);
		this.demoErrorCode = demoErrorCode;
	}
	
	public DemoBizException(DemoErrorCode demoErrorCode, String bizInfo, Throwable t) {
		super(demoErrorCode.getErrorCode(), demoErrorCode.getErrorMsg(), t);
		this.bizInfo = bizInfo;
		this.demoErrorCode = demoErrorCode;
	}
	
	public DemoBizException(DemoErrorCode demoErrorCode, String bizInfo) {
		super(demoErrorCode.getErrorCode(), demoErrorCode.getErrorMsg());
		this.bizInfo = bizInfo;
		this.demoErrorCode = demoErrorCode;
	}
	
	public String getReturnMessage(){
		String returnMsg = demoErrorCode.getReturnMsg();
		if(returnMsg==null || returnMsg.isEmpty()){
			returnMsg= demoErrorCode.getErrorMsg();
		}
		return returnMsg;
	}
	
	public String getBizInfo() {
		return bizInfo;
	}
	
	public void setBizInfo(String bizInfo) {
		this.bizInfo = bizInfo;
	}
	
	@Override
	public String toString(){
		return " [errorCode = " + getErrorCode() + ",errorMsg=" + getErrorMsg() + ",returnMsg=" + getReturnMessage() + "]";
	}
}
