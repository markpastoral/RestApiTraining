package com.trainig.restapidemo.user.bean.mapper;

public interface BaseMapper<B,D> {
    B dtoToBean(D userDTO);
    D beanToDTO(B post);
}
