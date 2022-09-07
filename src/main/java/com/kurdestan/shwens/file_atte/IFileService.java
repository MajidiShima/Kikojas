package com.kurdestan.shwens.file_atte;

import java.util.List;

public interface IFileService {

    FileAttachment save(FileAttachment fileAttachment);
    void delete(Long id);
    FileAttachment getById(Long id);
    List<FileAttachment> getAll();
    FileAttachment getByPlaceId(Long placeId);
    FileAttachment getByUserId(Long userId);

}
