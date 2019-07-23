package com.leyou.page.client;

import com.leyou.item.api.BrandApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author SanRay
 * @date 2019-07-16 10:49
 */
@FeignClient("item-service" )
public interface BrandClient extends BrandApi {
}
