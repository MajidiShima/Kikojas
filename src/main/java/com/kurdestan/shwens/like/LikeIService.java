package com.kurdestan.shwens.like;

import java.util.List;

public interface LikeIService {

    Like save(Like like);

    void delete(Long id);

    Like getById(Long id);

    List<Like> getAll();

    List<Like> getAllByPlaceId(Long placeId);

    List<Like> getAllByTypeLike(LikeType likeType);
}
