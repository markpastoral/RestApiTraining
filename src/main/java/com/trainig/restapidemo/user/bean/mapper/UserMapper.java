package com.trainig.restapidemo.user.bean.mapper;

import com.trainig.restapidemo.user.bean.User;
import com.trainig.restapidemo.user.bean.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDTO> {
}
