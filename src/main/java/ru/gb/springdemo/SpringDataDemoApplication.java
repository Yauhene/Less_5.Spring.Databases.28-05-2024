package ru.gb.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;
import ru.gb.springdemo.model.*;
import ru.gb.springdemo.repository.*;

@SpringBootApplication
public class SpringDataDemoApplication {

//	private static long maxId = 1;
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataDemoApplication.class, args);
		BooksRepository booksRepository = context.getBean(BooksRepository.class);
		System.out.println(booksRepository.findAll());
		Books.maxId = booksRepository.queryMaxId() + 1;
	}

}
