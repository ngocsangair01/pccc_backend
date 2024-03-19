package org.example.buoi3.mappers;

import org.example.buoi3.inputs.product.ProductDataInput;
import org.example.buoi3.models.AttributeDescription;
import org.example.buoi3.models.Image;
import org.example.buoi3.models.Product;
import org.example.buoi3.outputs.product.AttributeDescriptionDataOutput;
import org.example.buoi3.outputs.product.ProductDataOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

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
            @Mapping(target = "warranty",source = "warranty"),
            @Mapping(target = "images", source = "images", qualifiedByName = "convertImage")
    })
    ProductDataOutput toProductDataOutput(Product input);

    @Mappings({
            @Mapping(target = "content",source = "input.content"),
            @Mapping(target = "title",source = "input.title"),
    })
    AttributeDescriptionDataOutput toAttributeDescriptionOutput(AttributeDescription input);

    @Named("convertImage")
    static List<String> convertImg(List<Image> imageList){
        List<String> listImage = new ArrayList<>();
        for (Image value : imageList) {
            String image = value.getLink();
            listImage.add(image);
        }
        return listImage;
    }
}
