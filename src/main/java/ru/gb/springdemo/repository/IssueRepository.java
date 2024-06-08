package ru.gb.springdemo.repository;

import lombok.extern.slf4j.*;
import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.*;

import java.util.*;

@Slf4j
@Repository
public class IssueRepository {

  private static List<Issue> issues = null;

  public IssueRepository() {
    this.issues = new ArrayList<>();
    issues.addAll(List.of(
            new ru.gb.springdemo.model.Issue(3, 1),
            new ru.gb.springdemo.model.Issue(2, 2),
            new ru.gb.springdemo.model.Issue(1, 3)
    ));
    Issue.setReturnTimestamp(issues.get(1));
  }

  public void save(Issue issue) {
    // insert into ....
    issues.add(issue);
    log.info("Сохранили запрос " + issue.toString());
  }

  public Issue getIssueById(long id) {
    return issues.stream()
            .filter(it -> Objects.equals(it.getId(), id))
            .findFirst()
            .orElse(null);
  }

  public static List<Issue> getAll() {
    if (issues != null) {
      for (Issue issue: issues) {
        log.info(issue.toString() + "\n");
      }
    } else {
      log.info("Список issues пуст!");
    }

    return List.copyOf(issues);
  }

  public Issue getByReader(long id) {
    return issues.stream()
            .filter(it -> Objects.equals(it.getReaderId(), id))
            .findFirst()
            .orElse(null);
  }
}
