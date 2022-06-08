package com.example.demo.bootstrap;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap{
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @EventListener(ContextRefreshedEvent.class)
    private void initData() {
        Author robertMartin = new Author("Robert", "MARTIN");
        Publisher pearson = new Publisher("Pearson");
        Book cleanCode = new Book("Clean Code", "9780132350884");
        cleanCode.getAuthors().add(robertMartin);
        cleanCode.getPublishers().add(pearson);

        Author craigWalls = new Author("Craig", "WALLS");
        Publisher manningPublications = new Publisher("Manning Publications");
        Book springInAction = new Book("Spring in Action", "1935182358");
        springInAction.getAuthors().add(craigWalls);
        springInAction.getPublishers().add(manningPublications);

        bookRepository.save(cleanCode);
        bookRepository.save(springInAction);

    }

}
