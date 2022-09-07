package com.kurdestan.shwens.comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment ,Long> {
    List<Comment>findAllByUserId(Long userId);

    List<Comment>findAllByPlace(Long placeId);


}
