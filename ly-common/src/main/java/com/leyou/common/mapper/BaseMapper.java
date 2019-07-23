package com.leyou.common.mapper;

import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;


/**
 * @author SanRay
 * @date 2019-07-12 15:26
 */
@RegisterMapper
public interface BaseMapper<T> extends Mapper<T> , IdListMapper<T,Long>, InsertListMapper<T> {
}
