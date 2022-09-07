package com.kurdestan.shwens.place;

import com.kurdestan.shwens.image.Image;
import com.kurdestan.shwens.like.Like;
import com.kurdestan.shwens.user.User;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.stream.events.Comment;
import java.util.List;

@Entity
@Table(name = "tbl_place")
@Data
@Audited

public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "tbl_title")
    private String title;


    @NotNull
    @Column(name = "start_service")
    private Integer startService;


    @NotNull
    @Column(name = "end_service")
    private Integer endService;


    @NotNull
    @Column(name = "address")
    private String address;


    @NotNull
    @Column(name = "tbl_type")
    @Enumerated
    private Type type;


    @Column(name = "place_location")
    private Point<G2D> location;


    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> like;

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

}