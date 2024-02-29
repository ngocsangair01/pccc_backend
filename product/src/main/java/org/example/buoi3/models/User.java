package org.example.buoi3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.example.buoi3.models.base.BaseEntity;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.List;

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

    public User() {
    }

    public User(String name, String phoneNumber, String address, String gmail, String password, String avatar, List<CartDetail> cartDetails) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gmail = gmail;
        this.password = password;
        this.avatar = avatar;
        this.cartDetails = cartDetails;
    }

    public User(Long id, Long createBy, LocalDateTime createAt, Long updateBy, LocalDateTime updateAt, Boolean status, String name, String phoneNumber, String address, String gmail, String password, String avatar, List<CartDetail> cartDetails) {
        super(id, createBy, createAt, updateBy, updateAt, status);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gmail = gmail;
        this.password = password;
        this.avatar = avatar;
        this.cartDetails = cartDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }
}
