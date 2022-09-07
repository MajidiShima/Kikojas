package com.kurdestan.shwens.image;


import com.kurdestan.shwens.place.IPlaceService;
import com.kurdestan.shwens.place.Place;
import com.kurdestan.shwens.user.User;
import com.kurdestan.shwens.user.UserIService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageService implements ImageIService {

    private final ImageRepository repository;
    private final UserIService userService;
    private final IPlaceService placeService;

    @Override
    public Image saveImageForPlace(Image image, long placeId) {

        Place placeS = placeService.getById(placeId);
        image.setPlace(placeS);
        return repository.save(image);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Image getById(Long id) {
        Optional<Image> optImage=repository.findById(id);
        if(!optImage.isPresent()) {
            throw new NotFoundException("Not Found Image");
        }
        return optImage.get();
    }

    @Override
    public List<Image> getAll() {
        return (List<Image>) repository.findAll();
    }

    @Override
    public List<Image> getAllByPlaceId(Long placeId) {

        return repository.findAllByPlace_Id(placeId);
    }

    @Override
    public Image saveImageForUser(Image image, long userId) {
        User userI = userService.getById(userId);
        image.setUser(userI);

        return repository.save(image);
    }

    @Override
    public Image getByUserID(Long userId) {
        Optional<Image> optionalImageUser= repository.findById(userId);
        if(!optionalImageUser.isPresent()){
            throw new NotFoundException("NOt Found Users Image");
        }
        return optionalImageUser.get();
    }
}
