package org.example.buoi3.inputs.product;


import org.example.buoi3.models.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ProductDataInput {
    private String name;
    private String code;
    private String warranty;
    private String condition;
    private Double price;

    private Double promoPrice;

    private Long remaining;

    private MultipartFile image;

    private String manufacture;

    private List<MultipartFile> images;

    public ProductDataInput() {
    }

    public ProductDataInput(String name, String code, String warranty, String condition, Double price, Double promoPrice, Long remaining, MultipartFile image, String manufacture, List<MultipartFile> images) {
        this.name = name;
        this.code = code;
        this.warranty = warranty;
        this.condition = condition;
        this.price = price;
        this.promoPrice = promoPrice;
        this.remaining = remaining;
        this.image = image;
        this.manufacture = manufacture;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
