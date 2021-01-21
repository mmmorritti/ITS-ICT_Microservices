package org.mmmorritti.borrowing;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mmmorritti.borrowing.controllers.BorrowingController;
import org.mmmorritti.borrowing.models.Borrowing;
import org.mmmorritti.borrowing.repos.BorrowingRepository;
import org.mmmorritti.borrowing.services.NotificationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(BorrowingController.class)
@AutoConfigureMockMvc
public class BorrowingControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    NotificationClient notificationClient;

    @MockBean
    private BorrowingRepository borrowingRepository;

    //get all test
    @Test
    public void testGetAllBorrow(){
        try{
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/v2/borrowings")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testGetByID(){
        try{
            Borrowing borrow = new Borrowing();
            borrow.setBookId(1L);
            borrow.setStartBorrow("202020");
            borrow.setEndBorrow("202021");
            borrow.setBookId(345L);
            borrow.setCustomerId(5342L);
            borrow.setNotify("");
            borrowingRepository.findById(1L);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
