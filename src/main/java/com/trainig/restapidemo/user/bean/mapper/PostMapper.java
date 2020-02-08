package com.trainig.restapidemo.user.bean.mapper;

import com.trainig.restapidemo.user.bean.Post;
import com.trainig.restapidemo.user.bean.PostDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper extends BaseMapper<Post, PostDTO> {
}
