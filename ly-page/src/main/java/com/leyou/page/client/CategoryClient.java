package com.leyou.page.client;

import com.leyou.item.api.CategoryApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author SanRay
 * @date 2019-07-16 10:18
 */
@FeignClient("item-service")
public interface CategoryClient extends CategoryApi {

}
