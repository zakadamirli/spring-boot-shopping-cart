//package com.dreamshops.dynamoDB.product;
//
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
//
//public class DynamoCategoryConverter implements DynamoDBTypeConverter<String, DynamoProductCategory> {
//    @Override
//    public String convert(DynamoProductCategory dynamoProductCategory) {
//        return dynamoProductCategory.name();
//    }
//
//    @Override
//    public DynamoProductCategory unconvert(String s) {
//        return DynamoProductCategory.valueOf(s);
//    }
//}
