package com.example.pamphboard.dto;

import java.time.LocalDateTime;

public class PostDto {

  private long postIdx;
  private String author;
  private String password;
  private String title;
  private String content;
  private LocalDateTime regDate;

  public long getPostIdx() {
    return postIdx;
  }

  public void setPostIdx(long postIdx) {
    this.postIdx = postIdx;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public LocalDateTime getRegDate() {
    return regDate;
  }

  public void setRegDate(LocalDateTime regDate) {
    this.regDate = regDate;
  }
}
