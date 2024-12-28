package com.dailycodework.dreamshops.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private  Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<OrderDto> orders;
    private CartDto cart;
}
