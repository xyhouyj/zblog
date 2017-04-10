package com.eumji.zblog.mapper;

import com.eumji.zblog.vo.Partner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Created by GeneratorFx on 2017-04-10.
*/
@Mapper
public interface PartnerMapper {

Partner findById(final Object id);

List<Partner> findAll();

void save(final Partner entity);

Partner update(final Partner entity);

void delete(final Partner entity);

}
