//package com.dreamshops.dynamoDB.product;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//public class DynamoProductController {
//
//    private final DynamoProductService dynamoProductService;
//
//    @PostMapping("/product")
//    public String createProduct(@RequestBody DynamoProduct dynamoProduct) {
//        return dynamoProductService.createProduct(dynamoProduct);
//    }
//
//    @GetMapping("/product/{id}")
//    public DynamoProduct getProductById(@PathVariable String id) {
//        return dynamoProductService.getProductById(id);
//    }
//
//    @PutMapping("/update-product/{id}")
//    public DynamoProduct updateProduct(@PathVariable String id, @RequestBody DynamoProduct dynamoProduct){
//        return dynamoProductService.updateProduct(id,dynamoProduct);
//    }
//
//    @DeleteMapping("/delete-product/{id}")
//    public String deleteProduct(@PathVariable String id) {
//        return dynamoProductService.deleteProduct(id);
//    }
//}
