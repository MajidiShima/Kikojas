package com.kurdestan.shwens.place;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.util.List;

public interface IPlaceService {

    Place save(Place place);
    Place update(Place place);
    void delete(Long id);
    List<Place> getAll();
    Place getById(Long id);

    List<Place> findNearest(Point<G2D> candidPoint,double distance);


}
