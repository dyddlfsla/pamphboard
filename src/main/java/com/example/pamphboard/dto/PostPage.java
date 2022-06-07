package com.example.pamphboard.dto;

public class PostPage {

  private int min;
  private int max;
  private int prevPage;
  private int nextPage;
  private int totalOfPage;
  private int currentPage;

  PostPage(int totalOfPost, int currentPage, int pageSize, int totalPageBtn) {
    this.currentPage = currentPage;
    totalOfPage = totalOfPost / pageSize;
    if (totalOfPost % pageSize > 0) {
      totalOfPage++;
    }
  }

  public int getMin() {
    return min;
  }

  public int getMax() {
    return max;
  }

  public int getPrevPage() {
    return prevPage;
  }

  public int getNextPage() {
    return nextPage;
  }

  public int getTotalOfPage() {
    return totalOfPage;
  }

  public int getCurrentPage() {
    return currentPage;
  }
}
