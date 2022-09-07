package com.kurdestan.shwens.image;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/Image")
public class ImageController {

    private final ImageIService service;
    private final ImageMapper mapper;

    @PostMapping("/user")
    public ResponseEntity<Void> saveImageForUser(@RequestBody ImageDTO imageDTO) {
        Image image = mapper.toImage(imageDTO);
        service.saveImageForUser(image, imageDTO.getAttach_id());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/place")
    public ResponseEntity<Void> saveImageForPlace(@RequestBody ImageDTO imageDTO) {
        Image image = mapper.toImage(imageDTO);
        service.saveImageForPlace(image, imageDTO.getAttach_id());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ImageDTO> getById(@PathVariable Long id) {
        Image image = service.getById(id);
        ImageDTO imageDTO = mapper.toImageTDO(image);
        return ResponseEntity.ok(imageDTO);
    }

    @GetMapping
    public ResponseEntity<List<ImageDTO>> getAll() {
        List<Image> images = service.getAll();
        List<ImageDTO> imageDTOS = mapper.toImageDTOS(images);

        return ResponseEntity.ok(imageDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ImageDTO> getByUserId(@PathVariable Long userId) {
        Image image = service.getByUserID(userId);
        ImageDTO imageDTO = mapper.toImageTDO(image);
        return ResponseEntity.ok(imageDTO);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<ImageDTO>> getAllByPlaceId(@PathVariable Long placeId) {
        List<Image> imageLis = service.getAllByPlaceId(placeId);
        List<ImageDTO> imageDTOS = mapper.toImageDTOS(imageLis);
        return ResponseEntity.ok(imageDTOS);
    }










}
