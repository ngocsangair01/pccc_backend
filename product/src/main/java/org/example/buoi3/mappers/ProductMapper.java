package org.example.buoi3.mappers;

import com.cloudinary.Cloudinary;
import org.example.buoi3.inputs.product.ProductDataInput;
import org.example.buoi3.models.AttributeDescription;
import org.example.buoi3.models.Image;
import org.example.buoi3.models.Product;
import org.example.buoi3.outputs.product.AttributeDescriptionDataOutput;
import org.example.buoi3.outputs.product.ProductDataOutput;
import org.example.buoi3.utils.UploadFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
      Cloudinary cloudinary = new Cloudinary();

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

    @Named("convertImgs")
    static List<Image> convertImages(List<MultipartFile> multipartFiles){
        List<Image> images = new ArrayList<>();
        List<String> imageList = UploadFile.imagesToUrl(multipartFiles);
        for (int i = 0; i < imageList.size(); i++) {
            Image image = new Image(imageList.get(i));
            images.add(image);
        }
        return images;
    }

    @Named("convertImg")
    static String convertImage(MultipartFile multipartFile){
        if (multipartFile==null){
            return "";
        } else {
            return UploadFile.imageToUrl(multipartFile);
        }
    }

    @Mappings({
            @Mapping(target = "code",source = "input.code"),
            @Mapping(target = "condition",source = "input.condition"),
            @Mapping(target = "manufacture",source = "input.manufacture"),
            @Mapping(target = "image",source = "input.image", qualifiedByName = "convertImg"),
            @Mapping(target = "name",source = "input.name"),
            @Mapping(target = "price",source = "input.price"),
            @Mapping(target = "promoPrice",source = "input.promoPrice"),
            @Mapping(target = "remaining",source = "input.remaining"),
            @Mapping(target = "warranty",source = "input.warranty"),
            @Mapping(target = "images", source = "input.images", qualifiedByName = "convertImgs"),
            @Mapping(target = "id", source = "id")

    })
    Product toProduct(ProductDataInput input, Long id);
}
