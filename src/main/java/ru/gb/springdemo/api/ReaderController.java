package ru.gb.springdemo.api;

//import lombok.extern.slf4j.*;
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.web.bind.annotation.*;
//import ru.gb.springdemo.model.*;
//import ru.gb.springdemo.repository_old.*;
//
//@Slf4j
//@RestController
//@RequestMapping("/reader")
//public class ReaderController {
//    private final ReaderRepository readerRepository;
//    private IssueRepository issueRepository;
//
//    @Autowired
//    public ReaderController(ReaderRepository readerRepository) {
//        this.readerRepository = readerRepository;
//    }
//
//    @GetMapping("/{id}/issue")
//    public Issue getIssues(@PathVariable long id) {
//        return ReaderRepository.getIssue(id);
//
//    }
//
//}
