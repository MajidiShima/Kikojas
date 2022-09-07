package com.kurdestan.shwens.place;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;


@Repository
public interface PlaceRepository extends PagingAndSortingRepository<Place, Long> {

    @Query("select plc from Place plc where distance(plc.location, ?1) <?")
    List<Place> findAllWithDistance(Point<G2D> refPnt, double dist);

    @Query("select plc,distance(plc.location, ?1) as distance from Place  plc order by distance")
    List<Tuple> findNearest(Point<G2D> refPnt);

}
