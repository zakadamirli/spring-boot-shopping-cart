//package com.dreamshops.dynamoDB.product;
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//@Repository
//@RequiredArgsConstructor
//public class DynamoProductRepository {
//
//    final private DynamoDBMapper dynamoDBMapper;
//
//    public String createProduct(DynamoProduct dynamoProduct) {
//        dynamoDBMapper.save(dynamoProduct);
//        return dynamoProduct.getId();
//    }
//
//    public DynamoProduct getProductById(String id) {
//        return dynamoDBMapper.load(DynamoProduct.class, id);
//    }
//
//    public DynamoProduct updateProduct(String id, DynamoProduct dynamoProduct) {
//        DynamoProduct load = dynamoDBMapper.load(DynamoProduct.class, id);
//
//        load.setName(dynamoProduct.getName());
//        load.setBrand(dynamoProduct.getBrand());
//        load.setPrice(dynamoProduct.getPrice());
//        load.setInventory(dynamoProduct.getInventory());
//        load.setDescription(dynamoProduct.getDescription());
//        load.setCategory(dynamoProduct.getCategory());
//        dynamoDBMapper.save(load);
//
//        return dynamoDBMapper.load(DynamoProduct.class, id);
//    }
//
//    public String deleteProduct(String id) {
//        DynamoProduct load = dynamoDBMapper.load(DynamoProduct.class, id);
//        dynamoDBMapper.delete(load);
//
//        return load.getId() + " get deleted";
//    }
//}
