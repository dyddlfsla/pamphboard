package com.example.pamphboard.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
/*
* 테스트를 진행할 때 Junit 에 내장된 실행자 외에 다른 실행자를 사용하게 한다.
* 즉, 스프링 부트 테스트와 Junit 사이에 연결자 역할을 함.
*
* */
@WebMvcTest(controllers = HelloController.class)
/*
* 여러 스프링 테스트 어노테이션 중 Web(Spring MVC)에 집중할 수 있는 어노테이션이다.
* 이 어노테이션을 선언할 경우 @controller, @ControllerAdvice 등을 사용할 수 있다.
*
* */
public class HelloControllerTest {

  @Autowired
  private MockMvc mvc; //스프링 mvc 테스트의 시작점. 이 클래스를 통해 HTTP GET, POST 등에 대한 테스트를 수행한다.

  @Test
  public void helloTest() throws Exception {
    String hello = "hello";

    mvc.perform(get("/hello"))//MockMvc 를 통해 /hello 주소로 HTTP GET 요청을 보냄.
        .andExpect(status().isOk())//mvc.perform 의 결과를 검증함. HTTP Header 의 Status 가 ok 인지(200) 확인
        .andExpect(content().string(hello));//mvc.perform 의 결과를 검증함. 응답 본문의 내용(hello 가 맞는지)을 확인.
  }

}