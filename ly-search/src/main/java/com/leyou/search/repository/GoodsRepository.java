package com.leyou.search.repository;

import com.leyou.search.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author SanRay
 * @date 2019-07-16 10:51
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods,Long> {
}
