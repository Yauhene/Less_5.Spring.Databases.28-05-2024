package ru.gb.springdemo.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {

  private final List<Reader> readers;
  private final List<Issue> issues = IssueRepository.getAll();

  public ReaderRepository() {
    this.readers = new ArrayList<>();
  }

  @PostConstruct
  public void generateData() {
    readers.addAll(List.of(
      new ru.gb.springdemo.model.Reader("Игорь"),
      new ru.gb.springdemo.model.Reader("Вася"),
      new ru.gb.springdemo.model.Reader("Пафнутий"),
      new ru.gb.springdemo.model.Reader("Аркадий")
    ));
  }

  public Reader getReaderById(long id) {
    return readers.stream().filter(it -> Objects.equals(it.getId(), id))
      .findFirst()
      .orElse(null);
  }

  public static Issue getIssue(long id) {
    List<Issue> list = IssueRepository.getAll();
    return list.stream()
            .filter(it -> Objects.equals(it.getReaderId(), id))
            .findFirst()
            .orElse(null);
  }

}
