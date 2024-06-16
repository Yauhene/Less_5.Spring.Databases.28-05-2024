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
    this.id = maxId++;
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



//  public String getReaderName() {
//    long readerId = this.readerId;
//    Readers readers = ReaderRepository.findById(readerId);
//    List<Readers> rList = List.copyOf(ReaderRepository.findAll());
//    Optional<Readers> reader = rList.stream()
//            .filter(it -> Objects.equals(it.getId(), readerId))
//            .findFirst();
//    String readerName = reader.get().getName();
//    return readerName;
//  }

//  public String getBookName() {
//    long bookId = this.bookId;
//    List<Books> bList = List.copyOf(BooksRepository.findAll());
//    Optional<Books> book = bList.stream()
//            .filter(it -> Objects.equals(it.getId(), bookId))
//            .findFirst();
//    String bookName = book.get().getName();
//    return bookName;
//  }
}
