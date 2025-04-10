package com.vg.controller;

import com.vg.model.Book;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class BookController {

    private static final List<Book> booksList = List.of(
            new Book(1L, "Clean Code", "Robert C. Martin"),
            new Book(2L, "Effective Java", "Joshua Bloch")
    );

    @GetMapping("/books/{id}")
    public EntityModel<Book> getBook(@PathVariable Long id) {

        Optional<Book> foundBook = booksList.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();

        return foundBook.map(book ->
                EntityModel.of(book,
                        linkTo(methodOn(BookController.class).getBook(id)).withSelfRel(),
                        linkTo(methodOn(BookController.class).allBooks()).withRel("all-books"))
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    @GetMapping("/books")
    public CollectionModel<EntityModel<Book>> allBooks() {

        List<EntityModel<Book>> books = booksList
                .stream().map(book ->
                        EntityModel.of(book,
                                linkTo(methodOn(BookController.class).getBook(book.getId())).withSelfRel()
                                        .andAffordance(afford(methodOn(BookController.class).getBook(book.getId())))
                        )
                ).toList();

        return CollectionModel.of(books,
                linkTo(methodOn(BookController.class).allBooks()).withSelfRel()
        );
    }

}
