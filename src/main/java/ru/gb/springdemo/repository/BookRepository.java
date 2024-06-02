package ru.gb.springdemo.repository;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Repository
public class BookRepository {

  private final List<Book> books;

  public BookRepository() {

    this.books = new ArrayList<>();
  }

  @PostConstruct
  public void generateData() {
    books.addAll(List.of(
      new Book("Война и мир"),
      new Book("Мертвые души"),
      new Book("Чистый код")
    ));
  }

  public List<Book> getAll() {
    return List.copyOf(books);
  }


  public Book getBookById(long id) {
    return books.stream().filter(it -> Objects.equals(it.getId(), id))
      .findFirst()
      .orElse(null);
  }

  public Book addBook(Book book) {
    books.add(book);
    return book;
  }

  public void deleteBook(long id) {
    int index = -1;
    for (int i = 0; i <= books.size(); i++) {
      if (books.get(i).getId() == id) {
        index = i;
        break;
      }
    }
    books.remove(index);
  }
}
