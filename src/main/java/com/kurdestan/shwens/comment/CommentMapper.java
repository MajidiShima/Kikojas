package com.kurdestan.shwens.comment;


import com.kurdestan.shwens.place.PlaceMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PlaceMapper.class})
public interface CommentMapper {

    Comment toComment(CommentDTO commentDTO);
    CommentDTO toCommentDTO(Comment comment);
    List<Comment> toCommentList(List<CommentDTO> commentDTO);
    List<CommentDTO> toComDTOs(List<Comment> commentList);


}
