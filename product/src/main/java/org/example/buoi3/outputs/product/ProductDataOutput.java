package org.example.buoi3.outputs.product;

import org.example.buoi3.models.AttributeDescription;
import org.example.buoi3.models.Image;

import java.util.List;

public class ProductDataOutput {
    private String code;
    private String condition;
    private String image;
    private String manufacture;
    private String name;
    private Double price;
    private Double promoPrice;
    private Long remaining;
    private String warranty;
    private List<AttributeDescriptionDataOutput> attributeDescriptionDataOutputs;
    private List<String> images;


    public ProductDataOutput() {
    }

    public ProductDataOutput(String code, String condition, String image, String manufacture, String name, Double price, Double promoPrice, Long remaining, String warranty) {
        this.code = code;
        this.condition = condition;
        this.image = image;
        this.manufacture = manufacture;
        this.name = name;
        this.price = price;
        this.promoPrice = promoPrice;
        this.remaining = remaining;
        this.warranty = warranty;
    }

    public ProductDataOutput(String code, String image, String name) {
        this.code = code;
        this.image = image;
        this.name = name;
    }

    public ProductDataOutput(String code, String name, List<String> images) {
        this.code = code;
        this.name = name;
        this.images = images;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(Double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public Long getRemaining() {
        return remaining;
    }

    public void setRemaining(Long remaining) {
        this.remaining = remaining;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public List<AttributeDescriptionDataOutput> getAttributeDescriptionDataOutputs() {
        return attributeDescriptionDataOutputs;
    }

    public void setAttributeDescriptionDataOutputs(List<AttributeDescriptionDataOutput> attributeDescriptionDataOutputs) {
        this.attributeDescriptionDataOutputs = attributeDescriptionDataOutputs;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
