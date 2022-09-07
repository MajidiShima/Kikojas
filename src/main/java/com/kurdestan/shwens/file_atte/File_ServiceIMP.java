package com.kurdestan.shwens.file_atte;

import com.kurdestan.shwens.place.Place;
import com.kurdestan.shwens.user.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class File_ServiceIMP implements IFileService{

    private final IFileService service;
    private final FileRepository repository;



    @Override
    public FileAttachment save(FileAttachment fileAttachment) {
     Long fileId=fileAttachment.getPlace().getId();

     FileAttachDTO fileAttachDTO=service.getById(fileId);
        fileAttachment.setPlace(fileAttachDTO);
        return repository.save(fileAttachment) ;
    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);
    }

    @Override
    public FileAttachment getById(Long id) {
        Optional<FileAttachment> optFile=repository.findById(id);
        if(!optFile.isPresent()){
            throw new NotFoundException("Not Found FileAttachment");
        }

        return optFile.get();
    }

    @Override
    public List<FileAttachment> getAll() {
        List<FileAttachment> list= (List<FileAttachment>) repository.findAll();

        return list;
    }

    @Override
    public FileAttachment getByPlaceId(Long placeId) {
        Place place=service.getById(placeId);

        return repository.findByPlace(place);
    }

    @Override
    public FileAttachment getByUserId(Long userId) {
        User user=service.getById(userId);
        return repository.findByUser(user);
    }
}
