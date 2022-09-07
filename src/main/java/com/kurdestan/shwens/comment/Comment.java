package com.kurdestan.shwens.comment;

import com.kurdestan.shwens.commen.BaseEntity;
import com.kurdestan.shwens.image.Image;
import com.kurdestan.shwens.like.Like;
import com.kurdestan.shwens.place.Place;
import com.kurdestan.shwens.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_comment")
@Data
@Audited
public class Comment extends BaseEntity {

    private String coment;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name="image_id")
    private Image image;

}
