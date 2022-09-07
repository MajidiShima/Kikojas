package com.kurdestan.shwens.comment;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImp implements CommentIService{
    private final CommentRepository repository;
    private final CommentIService service;





    @Override
    public Comment save(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public List<Comment> getById(Long id) {
        Optional<Comment> optComment=repository.findById(id);
        if(!optComment.isPresent()) throw new NotFoundException("Comment Not Found ");
        return (List<Comment>) optComment.get();
    }

    @Override
    public List<Comment> getAll() {
        List<Comment> list= (List<Comment>) repository.findAll();
        return list;
    }

    @Override
    public List<Comment> getAllByPlaceId(Long placeId) {
        return repository.findAllByPlace(placeId);
    }

    @Override
    public List<Comment> getAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
