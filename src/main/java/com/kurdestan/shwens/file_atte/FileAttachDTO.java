package com.kurdestan.shwens.file_atte;

import com.kurdestan.shwens.commen.BaseDTO;
import com.kurdestan.shwens.place.PlaceDTO;
import com.kurdestan.shwens.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class FileAttachDTO extends BaseDTO {


    @ApiModelProperty(required = true,hidden = false)
    private String personalImage;


    @ApiModelProperty(required = true,hidden = false)
    private String lastLicenseImage;

    @ApiModelProperty(required = true,hidden = false)
    private UserDTO userDTO;

}
