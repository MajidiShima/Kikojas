package com.kurdestan.shwens.file_atte;

import java.util.List;

public interface IFileMapper  {
    FileAttachment toFileAttachment(FileAttachDTO fileAttachDTO);
    FileAttachDTO toFileAttachmentDTO(FileAttachment fileAttachment);
    List<FileAttachment> toFileAttachmentList(List<FileAttachDTO> FileAttachDTO);
    List<FileAttachDTO> toFileAttachmentDTOs(List<FileAttachment> fileAttachments);


}
