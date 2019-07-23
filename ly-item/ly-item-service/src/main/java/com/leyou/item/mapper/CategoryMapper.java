package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author SanRay
 * @date 2019-07-10 13:28
 */
public interface CategoryMapper extends Mapper<Category> , IdListMapper<Category, Long> {
}
