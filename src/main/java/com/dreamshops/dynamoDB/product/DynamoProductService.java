package com.dreamshops.dynamoDB.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DynamoProductService {

    private final DynamoProductRepository dynamoProductRepository;

    public String createProduct(DynamoProduct dynamoProduct) {
        return dynamoProductRepository.createProduct(dynamoProduct);
    }

    public DynamoProduct getProductById(String id) {
        return dynamoProductRepository.getProductById(id);
    }

    public DynamoProduct updateProduct(String id, DynamoProduct dynamoProduct) {
        return dynamoProductRepository.updateProduct(id,dynamoProduct);
    }

    public String deleteProduct(String id) {
        return dynamoProductRepository.deleteProduct(id);
    }
}
