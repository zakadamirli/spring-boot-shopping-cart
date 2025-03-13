package com.dreamshops.dynamoDB.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DynamoCartService {

    final private DynamoCartRepository dynamoCartRepository;

    public String createCart(DynamoCart dynamoCart) {
        return dynamoCartRepository.createCart(dynamoCart);
    }

    public DynamoCart getCartById(String id) {
        return dynamoCartRepository.getCartById(id);
    }

    public DynamoCart updateCart(String id, DynamoCart dynamoCart) {
        return dynamoCartRepository.updateCart(id,dynamoCart);
    }

    public String deleteCart(String id) {
        return dynamoCartRepository.deleteCart(id);
    }
}
