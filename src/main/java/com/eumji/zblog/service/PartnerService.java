package com.eumji.zblog.service;

import com.eumji.zblog.vo.Partner;
import java.util.List;

/**
* Created by GeneratorFx on 2017-04-10.
*/
public interface PartnerService {

Partner findById(final Object id);

List<Partner> findAll();

void save(final Partner entity);

Partner update(final Partner entity);

void delete(final Partner entity);

}
