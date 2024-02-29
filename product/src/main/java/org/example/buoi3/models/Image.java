package org.example.buoi3.models;

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

    public Image() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Image(String link) {
        this.link = link;
    }

    public Image(Long id, Long createBy, LocalDateTime createAt, Long updateBy, LocalDateTime updateAt, Boolean status, String link) {
        super(id, createBy, createAt, updateBy, updateAt, status);
        this.link = link;
    }
}
