package ru.gb.springdemo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import ru.gb.springdemo.model.*;

import java.util.*;

public interface ReaderRepository extends JpaRepository<Readers, Long>, PagingAndSortingRepository<Readers, Long> {

    long maxId = 1;



    @Query("select r from Readers r where r.name = :name")
    List<Readers> queryReaderByName(String name);

//    @Query("select max(id) from readers")
//    long queryMaxId();

    Readers deleteById(long id);

    Readers save(Readers readers);

    List<Readers> findAll();

    List<Readers> findById(long id);
//    List<Readers> findByIssuesId(long id);
}
