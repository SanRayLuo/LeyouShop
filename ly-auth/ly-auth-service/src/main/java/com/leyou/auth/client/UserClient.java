package com.leyou.auth.client;

import com.leyou.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author SanRay
 * @date 2019-07-22 15:34
 */
@FeignClient("user-service")
public interface UserClient extends UserApi {
}
