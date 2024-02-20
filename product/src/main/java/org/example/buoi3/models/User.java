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
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Nationalized;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User extends BaseEntity {

    @Column(name = "name")
    @Nationalized
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    @Nationalized
    private String address;

    @Column(name = "gmail")
    private String gmail;

    @Column(name = "password")
    private String password;

    @Column(name = "image")
    private String avatar;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<CartDetail> cartDetails;
}
