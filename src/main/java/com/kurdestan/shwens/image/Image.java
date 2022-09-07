package com.kurdestan.shwens.image;

import com.kurdestan.shwens.commen.BaseEntity;
import com.kurdestan.shwens.comment.Comment;
import com.kurdestan.shwens.like.Like;
import com.kurdestan.shwens.place.Place;
import com.kurdestan.shwens.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "tbl_Image")
@Data
@Audited
public class Image extends BaseEntity {



    @NotNull
    @Column(name = "image")
    private String image;

   @ManyToOne
   @JoinColumn(name="user_id")
   private User user;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @OneToMany(mappedBy = "image", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(mappedBy = "image", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments ;

}
