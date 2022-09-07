package com.kurdestan.shwens.image;

import java.util.List;

public interface ImageIService {

    void delete(Long id);
    Image getById(Long id);
    List<Image> getAll();


    Image saveImageForPlace(Image image, long placeId);
    List<Image> getAllByPlaceId(Long placeId);

    Image saveImageForUser(Image image, long userId);
    Image getByUserID(Long userId);

}
