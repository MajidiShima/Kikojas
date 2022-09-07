package com.kurdestan.shwens.user;


import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserIMapper {


    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);


}
