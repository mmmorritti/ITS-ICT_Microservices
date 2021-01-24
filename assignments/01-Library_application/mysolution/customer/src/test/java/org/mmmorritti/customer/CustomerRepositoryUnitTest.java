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

        Customer c2 = new Customer();
        c2.setCustomerId(2L);
        c2.setName("Name");
        c2.setSurname("Surname");
        c2.setStreet("Street");
        c2.setNumber(23);
        c2.setCity("Turin");
        c2.setTelephoneNumber(1234567L);
        customerRepository.save(c2);

        Customer c3 = new Customer();
        c3.setCustomerId(3L);
        c3.setName("Name");
        c3.setSurname("Surname");
        c3.setStreet("Street");
        c3.setNumber(23);
        c3.setCity("Turin");
        c3.setTelephoneNumber(1234567L);
        customerRepository.save(c3);

        customerRepository.deleteAll();
        assertEquals(0,customerRepository.findAll().size()  );
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

        Customer c2 = new Customer();
        c2.setCustomerId(2L);
        c2.setName("Name");
        c2.setSurname("Surname");
        c2.setStreet("Street");
        c2.setNumber(23);
        c2.setCity("Turin");
        c2.setTelephoneNumber(1234567L);
        customerRepository.save(c2);

        Customer c3 = new Customer();
        c3.setCustomerId(3L);
        c3.setName("Name");
        c3.setSurname("Surname");
        c3.setStreet("Street");
        c3.setNumber(23);
        c3.setCity("Turin");
        c3.setTelephoneNumber(1234567L);
        customerRepository.save(c3);

        customerRepository.deleteById(1L);
        assertEquals(2,customerRepository.findAll().size()  );
        System.out.println(c);
    }
}
