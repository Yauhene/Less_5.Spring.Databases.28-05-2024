package ru.gb.springdemo.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.*;

@Slf4j
@Data
@RequiredArgsConstructor
public class Book {

  public static long sequence = 1L;

  private final long id;
  private final String name;

  public Book(String name) {
    this(sequence++, name);
  }


}
