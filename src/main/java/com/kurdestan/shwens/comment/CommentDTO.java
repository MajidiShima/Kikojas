package com.kurdestan.shwens.comment;

import com.kurdestan.shwens.commen.BaseDTO;

import com.kurdestan.shwens.like.LikeDTO;
import com.kurdestan.shwens.place.PlaceDTO;
import com.kurdestan.shwens.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
public class CommentDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private String text;

    @ApiModelProperty(required = true, hidden = false)
    private UserDTO user;

    @ApiModelProperty(required = true, hidden = false)
    private PlaceDTO place;

    @ApiModelProperty(required = false, hidden = true)
    private List<CommentDTO> Comment;


    @ApiModelProperty(required = false, hidden = true)
    private List<LikeDTO> likeDTOList;
}
