package ru.gb.springdemo.model;

import jakarta.persistence.*;
import lombok.Data;
//import ru.gb.springdemo.repository_old.*;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Запись о факте выдачи книги (в БД)
 */
@Data
 @Entity
@Table(name = "issues")
public class Issue {

  public static long sequence = 1L;

  private final long id;
  private final long bookId;
  private final long readerId;

  /**
   * Дата выдачи
   */
  private final LocalDateTime issueTimestamp;
  /**
   * Дата возврата
   */
  private LocalDateTime returnTimestamp;

  public Issue(long bookId, long readerId) {
    this.id = sequence++;
    this.bookId = bookId;
    this.readerId = readerId;
    this.issueTimestamp = LocalDateTime.now();
    this.returnTimestamp = null;
  }

  public static void setReturnTimestamp(Issue issue) {
    issue.returnTimestamp = LocalDateTime.now();
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

  public String getReaderName() {
    long readerId = this.readerId;
    List<Reader> rList = List.copyOf(ReaderRepository.getReaders());
    Optional<Reader> reader = rList.stream()
            .filter(it -> Objects.equals(it.getId(), readerId))
            .findFirst();
    String readerName = reader.get().getName();
    return readerName;
  }

  public String getBookName() {
    long bookId = this.bookId;
    List<Book> bList = List.copyOf(BookRepository_Old.getAll());
    Optional<Book> book = bList.stream()
            .filter(it -> Objects.equals(it.getId(), bookId))
            .findFirst();
    String bookName = book.get().getName();
    return bookName;
  }
}
