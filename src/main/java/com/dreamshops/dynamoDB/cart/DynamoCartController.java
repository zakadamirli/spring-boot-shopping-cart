//package com.dreamshops.dynamoDB.cart;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//public class DynamoCartController {
//
//    final private DynamoCartService dynamoCartService;
//
//    @PostMapping("/cart")
//    public String createCart(@RequestBody DynamoCart dynamoCart) {
//        return dynamoCartService.createCart(dynamoCart);
//    }
//
//    @GetMapping("/cart/{id}")
//    public DynamoCart getCartById(@PathVariable String id) {
//        return dynamoCartService.getCartById(id);
//    }
//
//    @PutMapping("/update-customer/{id}")
//    public DynamoCart updateCart(@PathVariable String id, @RequestBody DynamoCart dynamoCart) {
//        return dynamoCartService.updateCart(id,dynamoCart);
//    }
//
//    @DeleteMapping("/delete-cart/{id}")
//    public String deleteCart(@PathVariable String id) {
//        return dynamoCartService.deleteCart(id);
//    }
//}
