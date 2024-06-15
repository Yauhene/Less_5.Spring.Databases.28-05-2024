package ru.gb.springdemo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;
import ru.gb.springdemo.model.*;

import java.util.*;

public interface BooksRepository extends JpaRepository<Books, Long>, PagingAndSortingRepository<Books, Long> {

    static long maxId = 1;
    @Query("select b from Books b where b.name = :name")
    List<Books> queryBookByName(String name);

    @Query("select max(id) from Books")
    long queryMaxId();

//    @Modifying
//    @Query(value = "insert into books(id, name) values(:id, :name)", nativeQuery = true)
//    Books addBook(@Param("id") long id, @Param("name") String name);
//    public Books addBook(Books book) {
//        BooksRepository.add(book);
//        return book;
//}
    Books save(Books books);
    List<Books> findAll();
    List<Books> findById(long id);
}
