package com.example.pamphboard.mybatis;

import java.sql.Connection;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ConnectionTest {

  @Autowired
  private SqlSessionFactory sqlSessionFactory;

  @Test
  public void connectionTest() {
    try (Connection connection = sqlSessionFactory.openSession().getConnection()) {
      System.out.println("연결 성공");
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}
