package com.kurdestan.shwens.like;

import com.kurdestan.shwens.commen.BaseDTO;
import com.kurdestan.shwens.place.PlaceDTO;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

@Data

public class LikeDTO extends BaseDTO {
    @ApiModelProperty(required = false, hidden = false)
    private PlaceDTO place;


}
