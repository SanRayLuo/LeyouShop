package com.leyou.cart.service;

import com.leyou.auth.pojo.UserInfo;
import com.leyou.cart.interceptor.UserInterceptor;
import com.leyou.cart.pojo.Cart;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SanRay
 * @date 2019-07-23 10:14
 */
@Service
public class CartService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX="cart:uid:";

    public void addCart(Cart cart) {
        // 获取登录用户
        UserInfo user = UserInterceptor.getUser();
        // key
       String key= KEY_PREFIX+ user.getId();
       // haskey
        String hashKey = cart.getSkuId().toString();
        // 记录num
        Integer num= cart.getNum();
        BoundHashOperations<String, Object, Object> ops = redisTemplate.boundHashOps(key);
        // 判断当前购物车商品是否存在
        if (ops.hasKey(hashKey)) {
            // 是,修改数量
            String json = ops.get(hashKey).toString();
            cart = JsonUtils.parse(json, Cart.class);
            cart.setNum(cart.getNum()+ num);

        }
        // 写回redis
        ops.put(hashKey,JsonUtils.serialize(cart));
    }

    public List<Cart> queryCartList() {
        // 获取登录用户
        UserInfo user = UserInterceptor.getUser();
        // key
        String key= KEY_PREFIX+ user.getId();

        if (!redisTemplate.hasKey(key)) {
            throw new LyException(ExceptionEnum.CART_NOT_FOUND);
        }
        BoundHashOperations<String, Object, Object> ops = redisTemplate.boundHashOps(key);
        List<Cart> carts = ops.values().stream().map(o -> JsonUtils.parse(o.toString(), Cart.class))
                .collect(Collectors.toList());
        return carts;
    }

    public void updateCartNum(Long skuId, Integer num) {
        // 获取登录用户
        UserInfo user = UserInterceptor.getUser();
        // key
        String key= KEY_PREFIX+ user.getId();
        String hashKey=skuId.toString();
        // 获取操作
        BoundHashOperations<String, Object, Object> ops = redisTemplate.boundHashOps(key);
        // 判断是否存在
        if (!ops.hasKey(hashKey)) {
            throw new LyException(ExceptionEnum.CART_NOT_FOUND);
        }
        // 查询
        Cart cart = JsonUtils.parse(ops.get(skuId.toString()).toString(), Cart.class);
        cart.setNum(num);

        // 写回redis
        ops.put(hashKey,JsonUtils.serialize(cart));
    }

    public void deleteCart(Long skuId) {
        // 获取登录用户
        UserInfo user = UserInterceptor.getUser();
        // key
        String key= KEY_PREFIX+ user.getId();

        // 删除
        redisTemplate.opsForHash().delete(key,skuId.toString());
    }
}
