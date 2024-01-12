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
@Table(name = "image")
public class Image extends BaseEntity {

    @Column(name = "link")
    @Nationalized
    private String link;



}
