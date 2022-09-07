package com.kurdestan.shwens.like;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface LikeMapper {

    Like toLike(LikeDTO likeDTO);

    List<Like> toLikes(List<LikeDTO> likeDTOS);

    LikeDTO toLikeDTO(Like like);

    List<LikeDTO> toLikesDTO(List<Like> likes);
}
