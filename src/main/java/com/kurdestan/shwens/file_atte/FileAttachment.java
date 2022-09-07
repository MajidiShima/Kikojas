package com.kurdestan.shwens.file_atte;

import com.kurdestan.shwens.commen.BaseEntity;
import com.kurdestan.shwens.place.Place;
import com.kurdestan.shwens.user.User;
import lombok.Data;
import org.hibernate.annotations.Entity;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_fileATTechment")
@Data
@Audited
public class FileAttachment extends BaseEntity {

    @NotNull
    @Column(name = "personal_image")
    private String personalImage;


    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
