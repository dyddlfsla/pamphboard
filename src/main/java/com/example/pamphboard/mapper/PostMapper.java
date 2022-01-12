package com.example.pamphboard.mapper;

import com.example.pamphboard.dto.PostDto;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PostMapper {

  @Insert("INSERT INTO BOARD_POST(writer, password, title, content) "
        + "VALUES(#{writer}, #{password}, #{title}, #{content})")
  void insert(PostDto postDto);

  @Select("SELECT * FROM BOARD_POST")
  List<PostDto> selectAll();

}
