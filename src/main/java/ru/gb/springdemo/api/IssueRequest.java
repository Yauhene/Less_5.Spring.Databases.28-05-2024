package ru.gb.springdemo.api;

import lombok.Data;

import java.time.*;

/**
 * Запрос на выдачу
 */
@Data
public class IssueRequest {

  /**
   * Идентификатор книги
   */
  private long bookId;

  /**
   * Идентификатор читателя
   */
  private long readerId;

  /**
   * Идентификатор времени выдачи
   */
  private LocalDateTime issueTimeStamp = LocalDateTime.now();
}
