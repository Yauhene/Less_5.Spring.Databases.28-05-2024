package ru.gb.springdemo.api;

import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.*;
import ru.gb.springdemo.repository.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/reader")
public class ReadersController {
    private ReaderRepository readerRepository;
    private IssueRepository issueRepository;

    @Autowired
    public void ReaderController(ReaderRepository readerRepository) {

        this.readerRepository = readerRepository;
    }

    public ReadersController() {
    }

    @GetMapping("/{id}")
    public List<Readers> getReader(@PathVariable long id) {
        return readerRepository.findById(id);
    }

    /**
     * Метод получения списка всех читателей
     * @return - список книг
     */
    @GetMapping(path = "/all")
    public List<Readers> getAllReaders() {
        return readerRepository.findAll();
    }

    /**
     * Метод добавления нового читателя
     * @return - список всех читателей
     */
    // восстановить в новых условиях
    @PostMapping("/add")
    public Readers addReader(@RequestBody Readers readers) {
        readers.setId(readers.getId() + 1);
        Readers.maxId = readerRepository.queryMaxId() + 1;
        return readerRepository.save(readers);
    }

    /**
     * Метод удаления читателя по его id
     * @param id - id удаляемой книги
     */
    @DeleteMapping("/del/{id}")
    public void deleteReader(@PathVariable long id) {
        readerRepository.deleteById(id);
        Readers.maxId = readerRepository.queryMaxId();
    }
}
