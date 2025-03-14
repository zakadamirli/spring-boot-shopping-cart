package com.dreamshops.dynamoDB.product;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class ProductCategory {

    @DynamoDBTypeConverted(converter = DynamoCategoryConverter.class)
    private DynamoProductCategory dynamoProductCategory;

}
