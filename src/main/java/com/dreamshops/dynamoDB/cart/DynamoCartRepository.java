package com.dreamshops.dynamoDB.cart;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DynamoCartRepository {

    final private DynamoDBMapper dynamoDBMapper;

    public String createCart(DynamoCart dynamoCart) {
        dynamoDBMapper.save(dynamoCart);
        return dynamoCart.getId();
    }

    public DynamoCart getCartById(String id) {
        return dynamoDBMapper.load(DynamoCart.class,id);
    }

    public DynamoCart updateCart(String id, DynamoCart dynamoCart) {
        DynamoCart load = dynamoDBMapper.load(DynamoCart.class, id);

        load.setTotalAmount(dynamoCart.getTotalAmount());
        load.setCreatedAt(dynamoCart.getCreatedAt());
        dynamoDBMapper.save(load);

        return dynamoDBMapper.load(DynamoCart.class, id);
    }

    public String deleteCart(String id) {
        DynamoCart load = dynamoDBMapper.load(DynamoCart.class, id);
        dynamoDBMapper.delete(load);

        return load.getId() + " get deleted";
    }
}
