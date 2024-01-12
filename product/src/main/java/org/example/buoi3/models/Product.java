package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.buoi3.models.base.BaseEntity;
import org.hibernate.annotations.Nationalized;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
