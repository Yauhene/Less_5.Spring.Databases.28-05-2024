package ru.gb.springdemo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;
import org.yaml.snakeyaml.tokens.*;
import ru.gb.springdemo.model.*;

import java.util.*;

public interface IssueRepository  extends JpaRepository<Issue, Long>, PagingAndSortingRepository<Issue, Long> {

    static long maxId = 1;

//    @Query("select i.id, i.book_id, i.reader_id, i.issue_time, i.return_time from issue i where i.id = :id")
//    List<Issue> queryIssueById(@Param("id")long id);

//    @Query("select max(id) from Issue")
//    Long queryIssuesMaxId();

//    @Query("select i.id from issue i where i.reader_id = :id")
//    Long queryIssueByReaderId(@Param("id") long id);

    void deleteById(Long id);

    Issue save(Issue issues);

//    List<Issue> findAllIssues();

//    Books findBooksById(long id);

//    List<Issue> findByReadersId(long id);

    List<Issue> findById(long id);

//    Readers findReadersById(long id);

//    Books findBooksId(long id);
}
