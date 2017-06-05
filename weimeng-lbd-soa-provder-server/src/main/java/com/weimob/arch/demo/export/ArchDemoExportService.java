package com.weimob.arch.demo.export;

import com.weimob.arch.demo.facade.ArchDemoFacadeService;
import com.weimob.arch.demo.model.DemoCommonErrorVo;
import com.weimob.arch.demo.model.request.FindArchPartnerBySexRequestVo;
import com.weimob.arch.demo.model.response.FindArchPartnerBySexResponseVo;
import com.weimob.arch.demo.service.ArchDemoService;
import com.weimob.soa.common.response.SoaResponse;

public class ArchDemoExportService extends BaseExportService implements ArchDemoService{

	private ArchDemoFacadeService archDemoFacadeService;
	
	public void setArchDemoFacadeService(ArchDemoFacadeService archDemoFacadeService) {
		this.archDemoFacadeService = archDemoFacadeService;
	}

	@Override
	public SoaResponse<FindArchPartnerBySexResponseVo, DemoCommonErrorVo> findArchPartnerBySex(FindArchPartnerBySexRequestVo requestVo) {
		return  process("findArchPartnerBySex", requestVo);
	}
	
	public <T> SoaResponse<T, DemoCommonErrorVo> process(String method, Object input) {
		return super.process(archDemoFacadeService, method, input, DemoCommonErrorVo.class);
	}
	
}
