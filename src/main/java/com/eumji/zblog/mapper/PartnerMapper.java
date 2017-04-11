package com.eumji.zblog.mapper;

import com.eumji.zblog.vo.Partner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Created by GeneratorFx on 2017-04-10.
*/
@Mapper
public interface PartnerMapper {


List<Partner> findAll();



}
