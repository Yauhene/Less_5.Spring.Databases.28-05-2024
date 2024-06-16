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
    @GetMapping("/{id}")
    public Books getBook(@PathVariable long id) {
        return booksRepository.findById(id).stream()
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод добавления новой книги
     * @return - список всех книг
     */
    @PostMapping("/add")
    public Books addBook(@RequestBody Books books) {
        books.setId(books.getId() + 1);
        return booksRepository.save(books);
    }

    /**
     * Метод удаления книги по ее id
     * @param id - id удаляемой книги
     */
    @DeleteMapping("/del/{id}")
    public void deleteBook(@PathVariable long id) {
        booksRepository.deleteById(id);
        Books.maxId = booksRepository.queryMaxId();
    }
}
