package com.weimob.arch.demo.export;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.weimob.arch.demo.exception.DemoBizException;
import com.weimob.arch.demo.exception.DemoErrorCode;
import com.weimob.soa.common.response.SoaResponse;

public class BaseExportService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseExportService.class);
	
	@SuppressWarnings("unchecked")
	public <T,ErrT> SoaResponse<T, ErrT> process(Object service, String method, Object input, Class<ErrT> errTClass){
		SoaResponse<T,ErrT> soaResponse = new SoaResponse<>();
		try {
			T t = null;
			try {
				t = (T)service.getClass().getMethod(method, input.getClass()).invoke(service, input);
			} catch (InvocationTargetException e) {
				throw e.getTargetException();
			}
			soaResponse.setResponseVo(t);
			soaResponse.setProcessResult(true);
			soaResponse.setReturnCode(DemoErrorCode.SUCCESS.getErrorCode());
			soaResponse.setReturnMsg(DemoErrorCode.SUCCESS.getErrorMsg());
		} catch (DemoBizException demoBizException) {
			LOGGER.error(method+" throw biz exception!, monitorTrackId:" + soaResponse.getMonitorTrackId(), demoBizException);
	    	soaResponse.setProcessResult(false);
			soaResponse.setReturnCode(demoBizException.getErrorCode());
			soaResponse.setReturnMsg(demoBizException.getReturnMessage());
			soaResponse.setErrT(buildErrorT(demoBizException, errTClass));
	    } catch(Throwable t){
	    	LOGGER.error(method+" throw system exception!, monitorTrackId:" + soaResponse.getMonitorTrackId(), t);
	    	soaResponse.setProcessResult(false);
			soaResponse.setReturnCode(DemoErrorCode.FAIL.getErrorCode());
			soaResponse.setReturnMsg(DemoErrorCode.FAIL.getErrorMsg());
	    }
		return soaResponse;
	}

	private <ErrT> ErrT buildErrorT(Exception exception,Class<ErrT> errTclass){
		ErrT errT = null;
		try {
			errT = errTclass.newInstance();
			if(errT!=null){
				BeanUtils.copyProperties(exception, errT);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return errT;
	}
}
