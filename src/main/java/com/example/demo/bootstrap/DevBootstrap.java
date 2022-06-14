package com.example.demo.bootstrap;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repositories.BookRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class DevBootstrap{

    private BookRepository bookRepository;

    public DevBootstrap(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void initData() {
        Author robertMartin = new Author("Robert", "MARTIN", LocalDate.of(1952, Month.DECEMBER, 5));
        Publisher pearson = new Publisher("Pearson");
        Book cleanCode = new Book("Clean Code", "9780132350884");
        cleanCode.getAuthors().add(robertMartin);
        cleanCode.getPublishers().add(pearson);

        Author craigWalls = new Author("Craig", "WALLS", LocalDate.of(1965, Month.FEBRUARY, 12));
        Publisher manningPublications = new Publisher("Manning Publications");
        Book springInAction = new Book("Spring in Action", "1935182358");
        springInAction.getAuthors().add(craigWalls);
        springInAction.getPublishers().add(manningPublications);

        bookRepository.save(cleanCode);
        bookRepository.save(springInAction);
    }

}
