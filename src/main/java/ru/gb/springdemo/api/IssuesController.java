package ru.gb.springdemo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
//import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.model.*;
import ru.gb.springdemo.repository.*;
import ru.gb.springdemo.service.IssueService;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/issue")
public class IssuesController {
  private final IssueRepository issueRepository;

  @Autowired
  public IssuesController(IssueRepository issueRepository) {
    this.issueRepository = issueRepository;
  }

  @Autowired
  private IssueService service;

  @PostMapping
  public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
    log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());

    Issue issue;
    try {
      issue = service.issue(request);
    } catch (NoSuchElementException e) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(issue);
  }

  @GetMapping(path = "/all")
  public List<Issue> getIssues() {
    return List.copyOf(issueRepository.findAll());
  }

  @GetMapping("/{id}")
    public List<Issue> getById(@PathVariable long id) {
      return issueRepository.findById(id);
    }

}
