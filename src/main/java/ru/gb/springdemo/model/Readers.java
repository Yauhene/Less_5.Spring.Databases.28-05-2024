package ru.gb.springdemo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
public class Readers {

  public static long maxId = 1L;

  @Id
  private long id;

  @Getter
  @Column(name = "name")
  private String name;

  public Readers(String name) {

    this.id = maxId++;
  }

}
