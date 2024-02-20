package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.buoi3.models.base.BaseEntity;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}