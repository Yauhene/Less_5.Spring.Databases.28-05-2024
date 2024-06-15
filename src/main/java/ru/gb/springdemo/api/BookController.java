package ru.gb.springdemo.api;

import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.*;
import ru.gb.springdemo.repository.*;
//import ru.gb.springdemo.repository_old.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
//    1.1 Реализовать контроллер по управлению книгами с ручками:
//    GET /book/{id} - получить описание книги, DELETE /book/{id} - удалить книгу, POST /book - создать книгу
    private final BooksRepository booksRepository;

    @Autowired
    public BookController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    /**
     * Метод получения списка всех книг
     * @return - список книг
     */
    @GetMapping(path = "/all")
    public List<Books> getBooks() {
        return booksRepository.findAll();
    }

    /**
     * Метод получения книги по ее id
     * @param id - id нужной книги
     * @return - книга
     */
    // восстановить в новых условиях
    @GetMapping("/{id}")
    public Books getBook(@PathVariable long id) {
        return booksRepository.findById(id).stream()
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод добавления новой книги
     *
     * @param - книга для добавления в список
     * @return - список всех книг
     */

    // восстановить в новых условиях
    @PostMapping("/add")
    public Books addBook(@RequestBody Books books) {
//    public void addBook() {
        return booksRepository.save(books);
    }

    /**
     * Метод удаления книги по ее id
     * @param id - id удаляемой книги
     */

    // восстановить в новых условиях
//    @DeleteMapping("/{id}")
//    public void deleteBook(@PathVariable long id) {
//        booksRepository.deleteBook(id);
//    }
}
