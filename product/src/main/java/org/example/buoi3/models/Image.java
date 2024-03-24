package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.buoi3.models.base.BaseEntity;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;

@Entity
@Table(name = "image")
public class Image extends BaseEntity {

    @Column(name = "link")
    @Nationalized
    private String link;

    @ManyToOne
    @JoinColumn(name = "id_product")
    @JsonIgnore
    private Product product;

    public Image() {
    }

    public Image(Long id, Long createBy, LocalDateTime createAt, Long updateBy, LocalDateTime updateAt, Boolean status, String link, Product product) {
        super(id, createBy, createAt, updateBy, updateAt, status);
        this.link = link;
        this.product = product;
    }

    public Image(String link, Product product) {
        this.link = link;
        this.product = product;
    }

    public Image(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
