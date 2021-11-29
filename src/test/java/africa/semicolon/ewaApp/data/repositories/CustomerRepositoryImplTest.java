package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryImplTest {
    CustomerRepository customerRepository;
    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Customer customer = saveCustomer();
        Customer savedCustomer = customerRepository.save(customer);
        assertEquals(customer, savedCustomer);
        assertEquals(1, customerRepository.findAll().size());
    }

    private Customer saveCustomer() {
        Customer customer = new Customer();
        customer.setEmail("yetunde@gmail.com");
        customer.setPassword("1234");
        customer.setFirstName("Bolu");
        customer.setLastName("Ola");
        return customerRepository.save(customer);
    }

    @Test
    void delete() {
        Customer savedCustomer = saveCustomer();
        customerRepository.delete(savedCustomer);
        assertEquals(0, customerRepository.findAll().size());
    }

    @Test
    void testDelete() {
        Customer savedCustomer = saveCustomer();
        customerRepository.delete(savedCustomer.getEmail());
        assertEquals(0, customerRepository.findAll().size());
    }

    @Test
    void findByEmail() {
        Customer savedCustomer = saveCustomer();
        assertEquals(savedCustomer, customerRepository.findByEmail(savedCustomer.getEmail()).get());
    }

    @Test
    void findAll() {
        Customer savedCustomer = saveCustomer();
        customerRepository.save(savedCustomer);
        assertEquals(1,customerRepository.findAll().size());
    }
}