package com.kurdestan.shwens.comment;


import com.kurdestan.shwens.place.Place;
import com.kurdestan.shwens.user.User;

import java.util.List;

public interface CommentIService {

    void delete(Long id);

    Comment save(Comment comment);
    List<Comment> getById(Long id);
    List<Comment>getAll();
    List<Comment> getAllByPlaceId(Long placeId);

    List<Comment>getAllByUserId(Long userId);


}
