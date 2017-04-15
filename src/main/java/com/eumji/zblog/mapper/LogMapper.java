package com.eumji.zblog.mapper;

import com.eumji.zblog.vo.LogInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Do
 * @package com.eumji.zblog.mapper
 * @name LogDao
 * @date 2017/4/10
 * @time 18:16
 */
@Mapper
public interface LogMapper {
    /**
     * 保存日志信息
     * @param log
     */
    void save(LogInfo log);
}
