package com.eumji.zblog.mapper;

import com.eumji.zblog.vo.Pager;
import com.eumji.zblog.vo.Partner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by GeneratorFx on 2017-04-10.
*/
@Mapper
public interface PartnerMapper {


List<Partner> findAll();


    void savePartner(Partner partner);

    /**
     * 分页查询好友列表
     * @param pager 分页条件
     * @param param
     * @return
     */
    List<Partner> loadPartner(@Param("pager")Pager pager, @Param("param") String param);

    Partner getPartnerById(Integer id);

    void deletePartner(Integer id);

    void updatePartner(Partner partner);

    int initPage(Pager pager);
}
