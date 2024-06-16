package ru.gb.springdemo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Запись о факте выдачи книги (в БД)
 */

@Entity
@Table(name = "issues")
@Data
public class Issue {

  public static long maxId = 1L;

  @Id
  private long id;

  @Column(name = "book_id")
  private long bookId;

  @Column(name = "reader_id")
  private long readerId;

  /**
   * Дата выдачи
   */
  @Column(name = "issue_time")
  private LocalDateTime issueTimestamp;
  /**
   * Дата возврата
   */
  @Column(name = "return_time")
  private LocalDateTime returnTimestamp;

  public Issue(long bookId, long readerId) {

    this.id = maxId;
    this.bookId = bookId;
    this.readerId = readerId;
    this.setIssueTimestamp(LocalDateTime.now());
  }

  public Issue() {

  }

  public void setReturnTimestamp() {

    this.setReturnTimestamp(LocalDateTime.now());
  }

  private void setReturnTimestamp(LocalDateTime now) {
  }

  public long getId() {
    return id;
  }

  public long getBookId() {
    return bookId;
  }

  public long getReaderId() {
    return readerId;
  }

  public LocalDateTime getIssueTimestamp() {
    return issueTimestamp;
  }

  public LocalDateTime getReturnTimestamp() {
    return returnTimestamp;
  }

}
