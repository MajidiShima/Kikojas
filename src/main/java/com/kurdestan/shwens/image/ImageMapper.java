package com.kurdestan.shwens.image;

import org.apache.catalina.LifecycleState;

import java.util.List;

public interface ImageMapper  {

    Image toImage(ImageDTO imageDTO);
    ImageDTO toImageTDO(Image image);
    List<Image> toImageList(List<Image> images);
    List<ImageDTO> toImageDTOS(List<ImageDTO> imageDTOList);


}
