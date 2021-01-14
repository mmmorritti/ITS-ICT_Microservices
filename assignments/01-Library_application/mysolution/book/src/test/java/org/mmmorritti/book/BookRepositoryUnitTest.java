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
    public void testAddOneCustomer(){
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




}

