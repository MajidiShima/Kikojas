package com.kurdestan.shwens.place;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-04T11:05:49+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class PlaceMapperImpl implements PlaceMapper {

    @Override
    public Place toPlace(PlaceDTO placeDTO) {
        if ( placeDTO == null ) {
            return null;
        }

        Place place = new Place();

        place.setLocation( convertLocationDtoToLocation( placeDTO.getLocationDTO() ) );
        place.setId( placeDTO.getId() );
        place.setTitle( placeDTO.getTitle() );
        place.setStartService( placeDTO.getStartService() );
        place.setEndService( placeDTO.getEndService() );
        place.setAddress( placeDTO.getAddress() );
        place.setType( placeDTO.getType() );

        return place;
    }

    @Override
    public PlaceDTO toPlaceDTO(Place place) {
        if ( place == null ) {
            return null;
        }

        PlaceDTO placeDTO = new PlaceDTO();

        placeDTO.setLocationDTO( convertLocationToLocationDTO( place.getLocation() ) );
        placeDTO.setId( place.getId() );
        placeDTO.setTitle( place.getTitle() );
        placeDTO.setStartService( place.getStartService() );
        placeDTO.setEndService( place.getEndService() );
        placeDTO.setAddress( place.getAddress() );
        placeDTO.setType( place.getType() );

        return placeDTO;
    }

    @Override
    public List<PlaceDTO> toPlaceDTOS(List<Place> placeList) {
        if ( placeList == null ) {
            return null;
        }

        List<PlaceDTO> list = new ArrayList<PlaceDTO>( placeList.size() );
        for ( Place place : placeList ) {
            list.add( toPlaceDTO( place ) );
        }

        return list;
    }

    @Override
    public List<Place> toPlace(List<PlaceDTO> placeDTOS) {
        if ( placeDTOS == null ) {
            return null;
        }

        List<Place> list = new ArrayList<Place>( placeDTOS.size() );
        for ( PlaceDTO placeDTO : placeDTOS ) {
            list.add( toPlace( placeDTO ) );
        }

        return list;
    }
}
