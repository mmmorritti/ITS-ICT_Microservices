package org.mmmorritti.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mmmorritti.customer.models.Customer;
import org.mmmorritti.customer.repos.CustomerRepository;
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
public class CustomerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testGetAllCustomer() throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/v2/customers")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCustomerByID(){
        try{
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

            customerRepository.findById(1L);
        }
        catch (Exception e){
            e.printStackTrace();;
        }
    }

}
