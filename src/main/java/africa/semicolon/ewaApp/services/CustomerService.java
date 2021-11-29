package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.models.Customer;
import africa.semicolon.ewaApp.dtos.requests.CustomerRequest;
import africa.semicolon.ewaApp.dtos.responses.CustomerResponse;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerResponse register(CustomerRequest customerRequest);

    List<Customer> getCustomer();

    void deleteCustomer(Customer customer);

    void deleteAllCustomers();

    Optional<Customer> findCustomerByEmail(String email);
}
