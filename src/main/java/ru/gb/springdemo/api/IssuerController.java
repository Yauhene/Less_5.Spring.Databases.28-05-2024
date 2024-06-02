package ru.gb.springdemo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.Issue;
import ru.gb.springdemo.repository.*;
import ru.gb.springdemo.service.IssuerService;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/issue")
public class IssuerController {
//* 1.3 В контроллере IssueController добавить ресурс GET /issue/{id} - получить описание факта выдачи

  @Autowired
  private IssueRepository issueRepository;
  @Autowired
  private IssuerService service;

//  @PutMapping
//  public void returnBook(long issueId) {
//    // найти в репозитории выдачу и проставить ей returned_at
//  }

  @PostMapping
  public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
    log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());

    final Issue issue;
    try {
      issue = service.issue(request);
    } catch (NoSuchElementException e) {
      return ResponseEntity.notFound().build();
    }

//    return ResponseEntity.status(HttpStatus.CONFLICT).body(issue);
    return ResponseEntity.status(HttpStatus.CREATED).body(issue);
  }

  @GetMapping(path = "/all")
  public List<Issue> getIssueList() {
//    log.info("List of issues contains " + issueRepository.getAll().size() + " records");
    return List.copyOf(issueRepository.getAll());
  }

  @GetMapping("/{id}")
    public Issue getIssueById(@PathVariable long id) {
      return issueRepository.getIssueById(id);
    }

}
