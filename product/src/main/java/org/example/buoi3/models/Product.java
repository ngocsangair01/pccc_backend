package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.buoi3.models.base.BaseEntity;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Column(name = "name")
    @Nationalized
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "warranty")
    private String warranty;

    @Column(name = "condition")
    private String condition;

    @Column(name = "price")
    private Double price;

    @Column(name = "promo_price")
    private Double promoPrice;

    @Column(name = "remaining")
    private Long remaining;

    @Column(name = "image")
    private String image;

    @Column(name = "manufacture")
    private String manufacture;

    @ManyToOne
    @JoinColumn(name = "id_provider")
    @JsonIgnore
    private Provider provider;


    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<AttributeDescription> attributeDescriptions;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Image> images;

    @ManyToMany
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<AttributeDescription> getAttributeDescriptions() {
        return attributeDescriptions;
    }

    public void setAttributeDescriptions(List<AttributeDescription> attributeDescriptions) {
        this.attributeDescriptions = attributeDescriptions;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Product(String name, String code, String warranty, String condition, Double price, Double promoPrice, Long remaining, String image, String manufacture, Provider provider, List<AttributeDescription> attributeDescriptions, List<Image> images, List<Category> categories) {
        this.name = name;
        this.code = code;
        this.warranty = warranty;
        this.condition = condition;
        this.price = price;
        this.promoPrice = promoPrice;
        this.remaining = remaining;
        this.image = image;
        this.manufacture = manufacture;
        this.provider = provider;
        this.attributeDescriptions = attributeDescriptions;
        this.images = images;
        this.categories = categories;
    }

    public Product(Long id, Long createBy, LocalDateTime createAt, Long updateBy, LocalDateTime updateAt, Boolean status, String name, String code, String warranty, String condition, Double price, Double promoPrice, Long remaining, String image, String manufacture, Provider provider, List<AttributeDescription> attributeDescriptions, List<Image> images, List<Category> categories) {
        super(id, createBy, createAt, updateBy, updateAt, status);
        this.name = name;
        this.code = code;
        this.warranty = warranty;
        this.condition = condition;
        this.price = price;
        this.promoPrice = promoPrice;
        this.remaining = remaining;
        this.image = image;
        this.manufacture = manufacture;
        this.provider = provider;
        this.attributeDescriptions = attributeDescriptions;
        this.images = images;
        this.categories = categories;
    }

    public Product() {
    }
}
