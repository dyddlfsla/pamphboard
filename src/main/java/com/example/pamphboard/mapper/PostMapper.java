package com.example.pamphboard.mapper;

import com.example.pamphboard.dto.PostDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

  @Insert("insert into BOARD_POST(writer, password, title, content) "
        + "values(#{writer}, #{password}, #{title}, #{content})")
  void insertPost(PostDto postDto);

}
