package com.leyou.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SanRay
 * @date 2019-07-23 17:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long skuId;// 商品skuId

    private Integer num;// 购买数量
}
