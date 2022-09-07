package com.kurdestan.shwens.place;

import lombok.AllArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor

public class placeService implements IPlaceService{

    private final PlaceRepository repository;

    @Override
    public Place save(Place place) {
        return repository.save(place);
    }

    @Override
    public Place update(Place place) {
        Place lastPlace=  getById(place.getId());

        lastPlace.setType(place.getType());
        lastPlace.setEndService(place.getEndService());
        lastPlace.setAddress(place.getAddress());
        lastPlace.setTitle(place.getTitle());
        lastPlace.setLocation(place.getLocation());
        return repository.save(lastPlace);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<Place> getAll() {
        return (List<Place>) repository.findAll();
    }

    @Override
    public Place getById(Long id)  {
       Optional<Place> optionalPlace=repository.findById(id);
        if (!optionalPlace.isPresent()){
            throw new NotFoundException("Not Found");
      }
        return  optionalPlace.get();


    }

    @Override
    public List<Place> findNearest(Point<G2D> candidPoint, double distance) {
        return repository.findAllWithDistance(candidPoint,distance);
    }
}
