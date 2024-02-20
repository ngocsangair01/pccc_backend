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

}
