package com.example.pamphboard.mapper;

import com.example.pamphboard.dto.PostDto;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PostMapper {

  @Insert("INSERT INTO BOARD_POST(author, password, title, content) "
        + "VALUES(#{author}, #{password}, #{title}, #{content})")
  Long insert(PostDto postDto);

  @Select("SELECT * FROM BOARD_POST WHERE post_idx = #{postIdx}")
  PostDto selectById(long postIdx);

  @Select("SELECT * FROM BOARD_POST")
  List<PostDto> selectAll();

  @Delete("DELETE FROM BOARD_POST WHERE post_idx = #{postIdx}")
  Long deleteById(long postIdx);

  @Update("UPDATE BOARD_POST SET title = #{title}, content = #{content} WHERE post_idx = #{postIdx}")
  Long updateById(PostDto postDto);
}
