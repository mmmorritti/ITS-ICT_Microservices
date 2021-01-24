package org.mmmorritti.book;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mmmorritti.book.models.Book;
import org.mmmorritti.book.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
public class BookIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BookRepository bookRepo;

    @Test
    public void testGetAllBook() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/v2/books")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBookById(){
        try{
            Book book = new Book();
            book.setBookId(1L);
            book.setAuthor("Franz Kafka");
            book.setTitle("La metamorfosi");
            book.setGenre("Racconto");
            book.setYear(1995);
            book.setPublishingHouse("Mondadori");
            bookRepo.save(book);

            Book book1 = new Book();
            book1.setBookId(1L);
            book1.setAuthor("Franz Kafka");
            book1.setTitle("La metamorfosi");
            book1.setGenre("Racconto");
            book1.setYear(1995);
            book1.setPublishingHouse("Mondadori");
            bookRepo.save(book1);

            bookRepo.findById(1L);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteBookById(){
        try {
            Book book = new Book();
            book.setBookId(1L);
            book.setAuthor("Franz Kafka");
            book.setTitle("La metamorfosi");
            book.setGenre("Racconto");
            book.setYear(1995);
            book.setPublishingHouse("Mondadori");
            bookRepo.save(book);

            Book book1 = new Book();
            book1.setBookId(1L);
            book1.setAuthor("Franz Kafka");
            book1.setTitle("La metamorfosi");
            book1.setGenre("Racconto");
            book1.setYear(1995);
            book1.setPublishingHouse("Mondadori");
            bookRepo.save(book1);

            bookRepo.deleteById(1L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
