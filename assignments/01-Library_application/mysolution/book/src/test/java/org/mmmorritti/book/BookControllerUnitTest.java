package org.mmmorritti.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mmmorritti.book.controllers.BookController;
import org.mmmorritti.book.models.Book;
import org.mmmorritti.book.repos.BookRepository;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
public class BookControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookRepository bookRepository;

    //get all test
    @Test
    public void testGetAllBook(){
        try{
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/v2/books")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    //get by id test giusto?
    @Test
    public void testGetByID(){
        try{
            Book book = new Book();
            book.setBookId(1L);
            book.setAuthor("author");
            book.setTitle("title");
            book.setGenre("genre");
            book.setYear(1995);
            book.setPublishingHouse("publishingHouse");
            bookRepository.save(book);
            bookRepository.findById(1L);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }




}
