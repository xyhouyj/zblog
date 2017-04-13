package com.eumji.zblog.service;

import com.eumji.zblog.vo.Pager;

/**
 * @author Do
 * @package com.eumji.zblog.service
 * @name PagerService
 * @date 2017/4/11
 * @time 21:46
 */
public interface PagerService {
    /**
     * 初始化分页信息
     * @return
     * @param pager
     */
    void initPage(Pager pager);

    void loadCategoryPager(Pager pager,Integer categoryId);
}
