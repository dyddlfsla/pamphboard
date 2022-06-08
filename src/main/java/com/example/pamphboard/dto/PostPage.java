package com.example.pamphboard.dto;

public class PostPage {

  private int min;
  private int max;
  private int prevPage;
  private int nextPage;
  private int totalOfPage;
  private int currentPage;

  public PostPage(int totalOfPost, int currentPage, int pageSize, int pageMoveBtn) {
    this.currentPage = currentPage;
    totalOfPage = totalOfPost / pageSize;
    if (totalOfPost % pageSize > 0) {
      totalOfPage++;
    }

    min = ((currentPage - 1) / totalOfPost) * totalOfPost + 1;
    max = min + pageMoveBtn - 1;

    if (max > totalOfPage) {
      max = totalOfPage;
    }

    prevPage = min - 1;
    nextPage = max + 1;

    if (nextPage > totalOfPage) {
      nextPage = totalOfPage;
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
