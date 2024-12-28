package com.dailycodework.dreamshops.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class CartDto {
    private Long cartId;
    private Set<CartItemDto> items;
    private BigDecimal price;
}
