package com.kurdestan.shwens.like;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LikeRepository extends PagingAndSortingRepository<Like, Long> {


    List<Like> findAllByPlaceId(long placeId);

    List<Like> findAllByTypeLike(LikeType type);
}

