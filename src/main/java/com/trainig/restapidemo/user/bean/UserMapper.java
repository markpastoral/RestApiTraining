package com.trainig.restapidemo.user.bean;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User dtoToBean(UserDTO userDTO);
    UserDTO beanToDTO(User user);
}
