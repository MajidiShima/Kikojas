package com.kurdestan.shwens.like;


import com.kurdestan.shwens.commen.BaseEntity;
import com.kurdestan.shwens.comment.Comment;
import com.kurdestan.shwens.image.Image;
import com.kurdestan.shwens.place.Place;
import com.kurdestan.shwens.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="tbl_like")
@Data
@Audited
public class Like extends BaseEntity {


    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;


    private LikeType type;

}
