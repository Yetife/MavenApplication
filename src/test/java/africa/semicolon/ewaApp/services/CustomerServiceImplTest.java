package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.models.Customer;
import africa.semicolon.ewaApp.dtos.requests.CustomerRequest;
import africa.semicolon.ewaApp.dtos.responses.CustomerResponse;
import africa.semicolon.ewaApp.exceptions.DuplicateUserEmailException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {
    CustomerService customerService;
    @BeforeEach
    void setUp() {
        customerService = new CustomerServiceImpl();
    }

    @AfterEach
    void tearDown() {
        customerService.deleteAllCustomers();
    }

    @Test
    void register() {
        CustomerResponse customerResponse = registerTestHelper();
        assertEquals(1, customerService.getCustomer().size());

    }

    private CustomerResponse registerTestHelper() {
        CustomerRequest customerRequest = new CustomerRequest();
        customerRequest.setCustomerEmail("yetunde@gmail.com");
        customerRequest.setCustomerPassword("1234");
        customerRequest.setFirstName("Bolu");
        customerRequest.setLastName("Ola");
        return customerService.register((customerRequest));
    }


    @Test
    void checkForDuplicateEmail_throwException() {
        registerTestHelper();
        assertThrows(DuplicateUserEmailException.class, this::registerTestHelper);
    }
}