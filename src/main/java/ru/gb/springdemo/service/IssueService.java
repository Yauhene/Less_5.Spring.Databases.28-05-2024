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
    System.out.println("/////////////////////////////////////// Вроде как вошли в service.issue(request)");
    Long readerDebt = issueRepository.queryIssueByReaderId(request.getReaderId());
    System.out.println(issueRepository.queryIssueByReaderId(request.getReaderId()));
    System.out.println("readerDebt = " + readerDebt);

    if (bookRepository.findById(request.getBookId()) == null) {
      System.out.println("Книги с id = " + request.getBookId() + " в нашей библиотеке нет.");
      throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
    }
    if (readerRepository.findById(request.getReaderId()) == null) {
      System.out.println("------------- if (readerRepository.findById(request.getReaderId()) == null)");
      throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
    }
    // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)
    if (readerDebt != null) {
      System.out.println("----------------------if (readerDebt != null)");
      Optional<Issue> iss = issueRepository.findById(readerDebt);
      Long bookId = iss.get().getBookId();
      String bName = bookRepository.findById(bookId).toString();
      String debtDescription = "Долг читателя: книга \"" + bName + "\", перебьется пока.";

      log.info(debtDescription);
      throw new NoSuchElementException("Должок !!! \"" + bName + "\"");
    }
    System.out.println("======== Прошли if'ы");
    System.out.println("request.getBookId(): " + request.getBookId());
    System.out.println("request.getReaderId(): " + request.getReaderId());

    Issue issue = new Issue(request.getBookId(), request.getReaderId());
    System.out.println(" ======================= На выходе вот такое issues : " + issue);
    issue.setId(issue.getId() + 1);
    issueRepository.save(issue);

    return issue;
  }

}
