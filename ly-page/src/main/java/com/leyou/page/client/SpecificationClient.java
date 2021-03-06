package com.leyou.page.client;

import com.leyou.item.api.SpecificationApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author SanRay
 * @date 2019-07-16 10:48
 */
@FeignClient("item-service" )
public interface SpecificationClient extends SpecificationApi {
}
