package org.mmmorritti.borrowing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mmmorritti.borrowing.models.Borrowing;
import org.mmmorritti.borrowing.repos.BorrowingRepository;
import org.mmmorritti.borrowing.services.NotificationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BorrowingRepositoryUnitTest {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @MockBean
    private NotificationClient notificationClient;

    @Test
    public void testEmptyDB(){
        assertEquals(0,borrowingRepository.findAll().size());
    }

    @Test
    public void testAddOneBorrowing(){
        Borrowing b = new Borrowing();
        b.setBorrowingId(1L);
        b.setStartBorrow("202020");
        b.setEndBorrow("212121");
        b.setNotification("notify");
        b.setBookId(2L);
        b.setCustomerId(1L);
        borrowingRepository.save(b);
        assertEquals(1,borrowingRepository.findAll().size());
    }


    @Test
    public void testDeleteAllBorrowing(){
        Borrowing b = new Borrowing();
        b.setBorrowingId(1L);
        b.setStartBorrow("202020");
        b.setEndBorrow("212121");
        b.setNotification("notify");
        b.setBookId(2L);
        b.setCustomerId(1L);
        borrowingRepository.save(b);
        assertEquals(1,borrowingRepository.findAll().size());
        borrowingRepository.deleteAll();
    }

    //delete one
    @Test
    public void testDeleteOneBorrowing(){
        Borrowing b = new Borrowing();
        b.setBorrowingId(1L);
        b.setStartBorrow("202020");
        b.setEndBorrow("212121");
        b.setNotification("notify");
        b.setBookId(2L);
        b.setCustomerId(1L);
        borrowingRepository.save(b);
        assertEquals(1,borrowingRepository.findAll().size());
        borrowingRepository.deleteById(1L);
    }

}
