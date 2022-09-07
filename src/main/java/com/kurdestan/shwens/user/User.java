package com.kurdestan.shwens.user;


import com.kurdestan.shwens.commen.BaseEntity;
import com.kurdestan.shwens.comment.Comment;
import com.kurdestan.shwens.image.Image;
import com.kurdestan.shwens.like.Like;
import com.kurdestan.shwens.place.Place;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_user")
@Audited
public class User extends BaseEntity {
    @NotNull
    private String name;

    @NotNull
    private String Email;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Image image;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> commentList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Place place;


}
