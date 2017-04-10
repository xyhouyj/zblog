package com.eumji.zblog.service.impl;

import com.eumji.zblog.mapper.PartnerMapper;
import com.eumji.zblog.service.PartnerService;
import com.eumji.zblog.vo.Partner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by GeneratorFx on 2017-04-10.
*/
@Service
@Transactional
public class PartnerServiceImpl implements PartnerService {

@Resource
private PartnerMapper partnerMapper;

@Override
public Partner findById(Object id) {
return partnerMapper.findById(id);
}

@Override
public List<Partner> findAll() {
return partnerMapper.findAll();
}

@Override
public void save(Partner entity) {
    partnerMapper.save(entity);
}

@Override
public Partner update(Partner entity) {
return partnerMapper.update(entity);
}

@Override
public void delete(Partner entity) {
    partnerMapper.delete(entity);
}
}
