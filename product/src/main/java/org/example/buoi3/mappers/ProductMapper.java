package org.example.buoi3.mappers;

import org.example.buoi3.models.AttributeDescription;
import org.example.buoi3.models.Product;
import org.example.buoi3.outputs.product.AttributeDescriptionDataOutput;
import org.example.buoi3.outputs.product.ProductDataOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(target = "code",source = "code"),
            @Mapping(target = "condition",source = "condition"),
            @Mapping(target = "manufacture",source = "manufacture"),
            @Mapping(target = "image",source = "image"),
            @Mapping(target = "name",source = "name"),
            @Mapping(target = "price",source = "price"),
            @Mapping(target = "promoPrice",source = "promoPrice"),
            @Mapping(target = "remaining",source = "remaining"),
            @Mapping(target = "warranty",source = "warranty")
    })
    ProductDataOutput toProductDataOutput(Product input);

    @Mappings({
            @Mapping(target = "content",source = "input.content"),
            @Mapping(target = "title",source = "input.title"),
    })
    AttributeDescriptionDataOutput toAttributeDescriptionOutput(AttributeDescription input);
}
