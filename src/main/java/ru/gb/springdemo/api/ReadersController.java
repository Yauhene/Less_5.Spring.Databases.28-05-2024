package ru.gb.springdemo.api;

import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.model.*;
import ru.gb.springdemo.repository.*;

import java.util.*;

//import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

@Slf4j
@RestController
@RequestMapping("/reader")
public class ReadersController {
    private ReaderRepository readersRepository;
    private IssueRepository issueRepository;

    @Autowired
    public void ReaderController(ReaderRepository readerRepository) {

        this.readersRepository = readerRepository;
    }

//    public ReadersController() {
//    }

    @GetMapping("/{id}")
    public List<Readers> getReader(@PathVariable long id) {
        return readersRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Readers> getAll() {
        return readersRepository.findAll();
    }
}
