package com.trainig.restapidemo.user.bean;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserBean dtoToBean(UserDTO userDTO);
    UserDTO beanToDTO(UserBean userBean);
}
