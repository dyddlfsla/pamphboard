package com.example.pamphboard.dto;

public class PostPagination {

  private int minPage;
  private int maxPage;
  private int prevPage;
  private int nextPage;
  private int totalOfPage;
  private int currentPage;

  public PostPagination(int totalOfPost, int currentPage, int pageSize, int numberOfPageBtn) {
    this.currentPage = currentPage;
    totalOfPage = totalOfPost / pageSize;
    if (totalOfPost % pageSize > 0) {
      totalOfPage++;
    }

    minPage = ((currentPage - 1) / numberOfPageBtn) * numberOfPageBtn + 1;
    maxPage = minPage + numberOfPageBtn - 1;

    if (maxPage > totalOfPage) {
      maxPage = totalOfPage;
    }

    prevPage = currentPage - 1;
    if (prevPage == 0) {
      prevPage = 1;
    }

    nextPage = currentPage + 1;

    if (nextPage > totalOfPage) {
      nextPage = totalOfPage;
    }
  }

  public int getMinPage() {
    return minPage;
  }

  public int getMaxPage() {
    return maxPage;
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
