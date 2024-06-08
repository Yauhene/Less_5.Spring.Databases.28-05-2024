package ru.gb.springdemo.model;

import lombok.*;

@Data
@RequiredArgsConstructor
public class Reader {

  public static long sequence = 1L;

  private final long id;
  @Getter
  private final String name;

  public Reader(String name) {

    this(sequence++, name);
  }

  public String getName() {
    return this.name;
  }
}
