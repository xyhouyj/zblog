package com.eumji.zblog.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Do
 * @package com.eumji.zblog.mapper
 * @name TagMapper
 * @date 2017/4/13
 * @time 18:55
 */
@Mapper
public interface TagMapper {

    int getTagCount();
}
