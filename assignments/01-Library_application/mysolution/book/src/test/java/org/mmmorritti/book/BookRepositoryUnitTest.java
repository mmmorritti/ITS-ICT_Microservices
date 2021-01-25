package org.mmmorritti.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mmmorritti.book.models.Book;
import org.mmmorritti.book.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryUnitTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testEmptyDB(){
        assertEquals(0,bookRepository.findAll().size());
    }

    @Test
    public void testAddOneBook(){
        Book book = new Book();
        book.setBookId(1L);
        book.setAuthor("Franz Kafka");
        book.setTitle("La metamorfosi");
        book.setGenre("Racconto");
        book.setYear(1995);
        book.setPublishingHouse("Mondadori");
        bookRepository.save(book);
        assertEquals(1,bookRepository.findAll().size()  );
    }


    //delete all
    @Test
    public void testDeleteAllBook(){
        Book book = new Book();
        book.setBookId(1L);
        book.setAuthor("Franz Kafka");
        book.setTitle("La metamorfosi");
        book.setGenre("Racconto");
        book.setYear(1995);
        book.setPublishingHouse("Mondadori");
        bookRepository.save(book);

        Book book1 = new Book();
        book1.setBookId(2L);
        book1.setAuthor("Franz Kafka");
        book1.setTitle("La metamorfosi");
        book1.setGenre("Racconto");
        book1.setYear(1995);
        book1.setPublishingHouse("Mondadori");
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setBookId(3L);
        book2.setAuthor("Franz Kafka");
        book2.setTitle("La metamorfosi");
        book2.setGenre("Racconto");
        book2.setYear(1995);
        book2.setPublishingHouse("Mondadori");
        bookRepository.save(book2);


        bookRepository.deleteAll();
        assertEquals(0,bookRepository.findAll().size()  );
    }

    //delete one
    @Test
    public void testDeleteOneBook(){
        Book book = new Book();
        book.setBookId(1L);
        book.setAuthor("author");
        book.setTitle("title");
        book.setGenre("genre");
        book.setYear(1995);
        book.setPublishingHouse("publishing");
        bookRepository.save(book);

        Book book1 = new Book();
        book1.setBookId(2L);
        book1.setAuthor("author");
        book1.setTitle("title");
        book1.setGenre("genre");
        book1.setYear(1995);
        book1.setPublishingHouse("publishing");
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setBookId(3L);
        book2.setAuthor("author");
        book2.setTitle("title");
        book2.setGenre("genre");
        book2.setYear(1995);
        book2.setPublishingHouse("publishing");
        bookRepository.save(book2);

        bookRepository.deleteById(1L);
        assertEquals(2,bookRepository.findAll().size()  );
    }


}

