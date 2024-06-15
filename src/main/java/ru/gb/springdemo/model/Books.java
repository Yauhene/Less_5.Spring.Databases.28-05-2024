package ru.gb.springdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.gb.springdemo.repository.*;

import static ru.gb.springdemo.repository.BooksRepository.*;


@Entity
@Table(name = "books")
@Data
public class Books {

  public static long maxId = 1;
//  public BooksRepository booksRepository;


  @Id
  private long id;

  @Column(name = "name")
  private String name;

  public Books() {
    System.out.println("maxId before: " + maxId);
    this.id = maxId++;
    System.out.println("maxId after: " + maxId);
  }

}
