package com.kurdestan.shwens.place;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlaceDTO {

    @ApiModelProperty(required = false,hidden = true)
    private Long id;


    @ApiModelProperty(required = true,hidden = false)
    private String title;


    @ApiModelProperty(required = true,hidden = false)
    private Integer startService;


    @ApiModelProperty(required = true,hidden = false)
    private Integer endService;


    @ApiModelProperty(required = true,hidden = false)
    private String address;


    @ApiModelProperty(required = true,hidden = false)
    private Type type;


    @ApiModelProperty(required = true,hidden = false)
    private LocationDTO locationDTO;


}
