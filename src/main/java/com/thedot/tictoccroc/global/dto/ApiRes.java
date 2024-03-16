package com.thedot.tictoccroc.global.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiRes<T> {

  private Result result;
  private T data;

  public ApiRes(T data) {
    this.result = new Result();
    this.data = data;
  }

  public ApiRes(boolean success, String code, String message) {
    this.result = new Result(success, code, message);
  }

  @Getter
  @ToString
  @AllArgsConstructor
  static class Result {
    private boolean success;
    private String code;
    private String message;

    Result() {
      this.success = true;
      this.code = "0000";
      this.message = "OK";
    }
  }
}
