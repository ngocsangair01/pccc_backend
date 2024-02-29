package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.buoi3.models.base.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
public class CartDetail extends BaseEntity {

    @Column(name = "number")
    private Long number;

    @Column(name = "id_product")
    private Long idProduct;

    @ManyToOne()
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;

    public CartDetail() {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CartDetail(Long number, Long idProduct, User user) {
        this.number = number;
        this.idProduct = idProduct;
        this.user = user;
    }

    public CartDetail(Long id, Long createBy, LocalDateTime createAt, Long updateBy, LocalDateTime updateAt, Boolean status, Long number, Long idProduct, User user) {
        super(id, createBy, createAt, updateBy, updateAt, status);
        this.number = number;
        this.idProduct = idProduct;
        this.user = user;
    }
}