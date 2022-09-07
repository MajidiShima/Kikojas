package com.kurdestan.shwens.comment;


import com.kurdestan.shwens.place.Place;
import com.kurdestan.shwens.user.User;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Comment")
public class CommentController {

    private final CommentIService service;
    private final CommentMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CommentDTO commentDTO) {
        Comment comment = mapper.toComment(commentDTO);
        service.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getById(@PathVariable Long id) {
        Comment comment = (Comment) service.getById(id);
        CommentDTO commentDTO = mapper.toCommentDTO(comment);
        return ResponseEntity.ok(commentDTO);
    }
    @GetMapping
    public ResponseEntity<List<CommentDTO>> getAll() {
        List<Comment> likes = service.getAll();
        List<CommentDTO> commentDTOS = mapper.toComDTOs(likes);

        return ResponseEntity.ok(commentDTOS);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CommentDTO>> getAllByUserId(@PathVariable Long userId) {
        List<Comment> commentList = service.getAllByUserId(userId);
        List<CommentDTO> commentDTOS=mapper.toComDTOs(commentList);
        return ResponseEntity.ok().body(commentDTOS);
    }

    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<CommentDTO>> getAllByPlaceId(@PathVariable Long placeId) {
        Place place = (Place) service.getAllByPlaceId(placeId);
        CommentDTO commentDTO= mapper.toCommentDTO();
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }










}
