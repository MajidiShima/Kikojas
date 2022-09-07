package com.kurdestan.shwens.file_atte;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/file-attachment/")
@AllArgsConstructor
public class FileController {

    private final IFileService service;
    private IFileMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody FileAttachDTO fileAttachmentDTO){
        FileAttachment fileAttachment=mapper.toFileAttachment(fileAttachmentDTO);
        service.save(fileAttachment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<FileAttachDTO> getById(@PathVariable Long id ){

        FileAttachment fileAttachment=    service.getById(id);
        FileAttachDTO fileAttachmentDTO=mapper.toFileAttachmentDTO(fileAttachment);
        return ResponseEntity.ok(fileAttachmentDTO);
    }
    @GetMapping("/v1")
    public ResponseEntity<List<FileAttachDTO>> getAll(){

        List<FileAttachment> fileAttachments=    service.getAll();


        List<FileAttachDTO> fileAttachmentDTOS=    mapper.toFileAttachmentDTOs(fileAttachments);


        return ResponseEntity.ok(fileAttachmentDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/get-by-User/{user}")
    public ResponseEntity<FileAttachDTO> getByUserId(@PathVariable Long user ){

        FileAttachment fileAttachment=    service.getByPlaceId(user);
        FileAttachDTO fileAttachmentDTO=mapper.toFileAttachmentDTO(fileAttachment);
        return ResponseEntity.ok(fileAttachmentDTO);
    }


    @GetMapping("/v1/get-byPlace/{place}")
    public ResponseEntity<FileAttachDTO> getByPlaceId(@PathVariable Long place ){

        FileAttachment fileAttachment=    service.getByPlaceId(place);
        FileAttachDTO fileAttachmentDTO=mapper.toFileAttachmentDTO(fileAttachment);
        return ResponseEntity.ok(fileAttachmentDTO);
    }
}
