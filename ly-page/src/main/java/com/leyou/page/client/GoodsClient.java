package com.leyou.page.client;

import com.leyou.item.api.GoodsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author SanRay
 * @date 2019-07-16 10:27
 */
@FeignClient("item-service" )
public interface GoodsClient extends GoodsApi {
}
