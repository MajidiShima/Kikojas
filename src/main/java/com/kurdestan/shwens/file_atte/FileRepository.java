package com.kurdestan.shwens.file_atte;


import com.kurdestan.shwens.place.Place;
import com.kurdestan.shwens.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileRepository extends PagingAndSortingRepository<FileAttachment,Long> {

FileAttachment findByPlace(Place place);

FileAttachment findByUser(User user);
}
