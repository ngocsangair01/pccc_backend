package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "provider")
public class Provider extends BaseEntity {

    @Column(name = "name")
    @Nationalized
    private String name;

    @OneToMany(mappedBy = "provider")
    @JsonIgnore
    private List<Product> products;
}