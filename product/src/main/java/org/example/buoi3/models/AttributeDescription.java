package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.buoi3.models.base.BaseEntity;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "attribute_description")
public class AttributeDescription extends BaseEntity {

    @Column(name = "title")
    @Nationalized
    private String title;


    @Column(name = "content")
    @Nationalized
    private String content;


    @ManyToOne
    @JoinColumn(name = "id_product")
    @JsonIgnore
    private Product product;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public AttributeDescription(String title, String content, Product product) {
        this.title = title;
        this.content = content;
        this.product = product;
    }

    public AttributeDescription(Long id, Long createBy, LocalDateTime createAt, Long updateBy, LocalDateTime updateAt, Boolean status, String title, String content, Product product) {
        super(id, createBy, createAt, updateBy, updateAt, status);
        this.title = title;
        this.content = content;
        this.product = product;
    }

    public AttributeDescription() {
    }
}
