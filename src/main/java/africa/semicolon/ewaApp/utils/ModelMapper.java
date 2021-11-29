package africa.semicolon.ewaApp.utils;

import africa.semicolon.ewaApp.data.models.Customer;
import africa.semicolon.ewaApp.dtos.requests.CustomerRequest;
import africa.semicolon.ewaApp.dtos.responses.CustomerResponse;

public class ModelMapper {
    public static Customer map(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setEmail(customerRequest.getCustomerEmail());
        customer.setPassword(customerRequest.getCustomerPassword());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());

        return customer;
    }

    public static CustomerResponse map(Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerEmailAdress(customer.getEmail());
        return customerResponse;
    }
}
