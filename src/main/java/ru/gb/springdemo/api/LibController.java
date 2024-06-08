package ru.gb.springdemo.api;


import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class LibController {

@RequestMapping("/ui/library")
    public String library() {
    return "library";
}
}
