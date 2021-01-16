package org.mmmorritti.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mmmorritti.customer.models.Customer;
import org.mmmorritti.customer.repos.CustomerRepository;
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
public class CustomerRepositoryUnitTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testEmptyDB(){
        assertEquals(0,customerRepository.findAll().size());
    }

    @Test
    public void testAddOneCustomer(){
        Customer c = new Customer();
        c.setCustomerId(1L);
        c.setName("Name");
        c.setSurname("Surname");
        c.setStreet("Street");
        c.setNumber(23);
        c.setCity("Turin");
        c.setTelephoneNumber(1234567L);
        customerRepository.save(c);
        assertEquals(1,customerRepository.findAll().size()  );
    }

    @Test
    public void testDeleteAllCustomer(){
        Customer c = new Customer();
        c.setCustomerId(1L);
        c.setName("Name");
        c.setSurname("Surname");
        c.setStreet("Street");
        c.setNumber(23);
        c.setCity("Turin");
        c.setTelephoneNumber(1234567L);
        customerRepository.save(c);
        assertEquals(1,customerRepository.findAll().size()  );
        customerRepository.deleteAll();
    }

    //delete one
    @Test
    public void testDeleteOneCustomer(){
        Customer c = new Customer();
        c.setCustomerId(1L);
        c.setName("Name");
        c.setSurname("Surname");
        c.setStreet("Street");
        c.setNumber(23);
        c.setCity("Turin");
        c.setTelephoneNumber(1234567L);
        customerRepository.save(c);
        assertEquals(1,customerRepository.findAll().size()  );
        customerRepository.deleteById(1L);
    }
}
