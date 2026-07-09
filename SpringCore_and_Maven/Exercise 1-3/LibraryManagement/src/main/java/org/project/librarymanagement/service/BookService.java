package org.project.librarymanagement.service;

import org.project.librarymanagement.repository.BookRepository;

public class BookService{
    private BookRepository bookRepository;

    public void setRepository(BookRepository repository) {
        this.bookRepository = repository;
    }

    public void displayService() {
        System.out.println("Book Service is working...");
        bookRepository.displayRepository();
    }
}
