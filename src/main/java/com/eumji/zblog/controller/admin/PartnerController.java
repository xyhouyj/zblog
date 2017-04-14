package com.eumji.zblog.controller.admin;

import com.eumji.zblog.service.PartnerService;
import com.eumji.zblog.util.ResultInfo;
import com.eumji.zblog.util.ResultInfoFactory;
import com.eumji.zblog.vo.Partner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * FILE: com.eumji.zblog.controller.admin.PartnerController.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/14
 * TIME: 22:28
 */
@RestController
@RequestMapping("/admin/partner")
public class PartnerController {
    @Resource
    private PartnerService partnerService;

    @RequestMapping("/add")
    public ResultInfo savePartner(Partner partner){
        try {
            partnerService.savePartner(partner);
        }catch (Exception e){
            return ResultInfoFactory.ERROR_RESULT;
        }
       return ResultInfoFactory.SUCCESS_RESULT;

    }
}
