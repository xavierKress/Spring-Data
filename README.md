# SpringBoot Training

This project was built using Spring Initializr with
- Spring Boot DevTools
- Spring Web Starter
- Tymeleaf
- Spring Data JPA
  -H2 DB
- Spring Boot Actuator

## What we have done

- We created a new project using Spring initializr 
- We created two POJO classes
- We made the mapping with JPA using annotations
    - @Entity
    - @id
    - @GeneratedValue(strategy = GenerationType.AUTO)
    - @ManyToMany
- We configures h2 console
- We launched the application and connected to the console
- We saw that hibernate created two tables and two relationship tables
- We broke that problem by adding mapping information using annotations
- We added two crud repositories interfaces for our model classes
- We added a bootstrap class to inject data at application launch 
- We added a new Publisher Entity with a ManyToMany relation on Books
