package com.example.pamphboard.mapper;

import com.example.pamphboard.dto.PostDto;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PostMapper {

  @Insert("INSERT INTO BOARD_POST(author, password, title, content) "
        + "VALUES(#{author}, #{password}, #{title}, #{content})")
  Long insert(PostDto postDto);

  @Select("SELECT * FROM BOARD_POST WHERE post_idx = #{post_idx}")
  PostDto selectOne(long postIdx);

  @Select("SELECT * FROM BOARD_POST")
  List<PostDto> selectAll();
}
