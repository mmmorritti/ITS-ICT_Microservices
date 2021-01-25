package org.mmmorritti.book.controllers;


import lombok.extern.slf4j.Slf4j;
import org.mmmorritti.book.models.Book;
import org.mmmorritti.book.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/v2/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //set book
    @RequestMapping(method = RequestMethod.PUT)
    public void setBook(@RequestBody Book book){ //spring --> json body to object java User
        bookRepository.save(book);//salva utente in db
        System.out.println(book);
    }

    //get all
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Book> getAllBooks() {
        log.info("Get BOOK");
        return bookRepository.findAll();
    }


    //get book
    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable long bookId){
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        if(bookOpt.isPresent()){
            log.info("Get book BY id");
            return bookOpt.get();
            log.info("ok");
        }else{
            log.error("book not found");
            return null;
        }
    }

    //edit book
    @RequestMapping(value = "/{bookId}", method = RequestMethod.POST)
    public Book editBook(@RequestBody Book book, @PathVariable long bookId){
        log.info("book saved");
        return bookRepository.save(book);
    }

    //delete by ID
    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable long bookId){
        log.info("deliting " + bookId);
        bookRepository.deleteById(bookId);
        log.info("Book deleted");
    }

    //delete all book
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllBook() {
        log.info("delinting");
        bookRepository.deleteAll();
        log.info("deleted all book");
    }



}
