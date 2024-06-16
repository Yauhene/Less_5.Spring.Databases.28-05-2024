package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.api.IssueRequest;
import ru.gb.springdemo.model.*;
import ru.gb.springdemo.repository.*;
//import ru.gb.springdemo.model.Issue;
//import ru.gb.springdemo.repository_old.IssueRepository;
//import ru.gb.springdemo.repository_old.ReaderRepository;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class IssueService {

  // спринг это все заинжектит
  private final BooksRepository bookRepository;
  private final ReaderRepository readerRepository;
  private final IssueRepository issueRepository;

  public Issue issue(IssueRequest request) {

    long readerDebt = issueRepository.queryIssueByReaderId(request.getReaderId());

    if (bookRepository.findById(request.getBookId()) == null) {
      throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
    }
    if (readerRepository.findById(request.getReaderId()) == null) {
      throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
    }
    // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)
    if (readerDebt >= 0) {

      Issue iss = (Issue) issueRepository.findById(readerDebt);
      long bookId = iss.getBookId();
      String bName = bookRepository.findById(bookId).toString();
      String debtDescription = "Долг читателя: книга \"" + bName + "\", перебьется пока.";

      log.info(debtDescription);
      throw new NoSuchElementException("Должок !!! \"" + bName + "\"");
    }


    Issue issues = new Issue(request.getBookId(), request.getReaderId());
    issueRepository.save(issues);

    return issues;
  }

}
