package ru.gb.springdemo.api;

import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.*;
import ru.gb.springdemo.repository.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
//    1.1 Реализовать контроллер по управлению книгами с ручками:
//    GET /book/{id} - получить описание книги, DELETE /book/{id} - удалить книгу, POST /book - создать книгу
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Метод получения списка всех книг
     * @return - список книг
     */
    @GetMapping(path = "/all")
    public List<Book> getBooks() {
        return bookRepository.getAll();
    }

    /**
     * Метод получения книги по ее id
     * @param id - id нужной книги
     * @return - книга
     */
    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return bookRepository.getBookById(id);
    }

    /**
     * Метод добавления новой книги
     * @param book - книга для добавления в список
     * @return - список всех книг
     */
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.addBook(book);
    }

    /**
     * Метод удаления книги по ее id
     * @param id - id удаляемой книги
     */
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookRepository.deleteBook(id);
    }
}
