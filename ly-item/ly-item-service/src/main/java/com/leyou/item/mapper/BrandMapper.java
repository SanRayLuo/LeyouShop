package com.leyou.item.mapper;

import com.leyou.common.mapper.BaseMapper;
import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author SanRay
 * @date 2019-07-10 16:54
 */
public interface BrandMapper extends BaseMapper<Brand> {

    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) VALUES (#{cid},#{bid})")
    int  insertCategoryBrand(@Param("cid") Long id, @Param("bid") Long  bid);

    @Select("SELECT b.* FROM tb_brand b INNER JOIN tb_category_brand cb ON b.id = cb.brand_id WHERE cb.category_id = #{cid}")
    List<Brand> queryByCategoryId(@Param("cid")Long cid);
}
