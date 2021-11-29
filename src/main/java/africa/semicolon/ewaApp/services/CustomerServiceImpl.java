package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.models.Customer;
import africa.semicolon.ewaApp.data.repositories.CustomerRepository;
import africa.semicolon.ewaApp.data.repositories.CustomerRepositoryImpl;
import africa.semicolon.ewaApp.dtos.requests.CustomerRequest;
import africa.semicolon.ewaApp.dtos.responses.CustomerResponse;
import africa.semicolon.ewaApp.exceptions.CustomerNotFoundException;
import africa.semicolon.ewaApp.exceptions.DuplicateUserEmailException;
import africa.semicolon.ewaApp.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    private static final CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public CustomerResponse register(CustomerRequest customerRequest) {
        Optional<Customer> detailsSavedInDatabase = customerRepository.findByEmail(customerRequest.getCustomerEmail());
        if (detailsSavedInDatabase.isPresent())
            throw new DuplicateUserEmailException("Email" + customerRequest.getCustomerEmail() + "already exist");
//        if(detailsSavedInDatabase.isEmpty()) {
//            throw new CustomerNotFoundException("Customer not found");}
        Customer customer = ModelMapper.map(customerRequest);
        Customer savedCustomer =customerRepository.save(customer);

        return ModelMapper.map(savedCustomer);
    }

    @Override
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }


    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void deleteAllCustomers() {
        customerRepository.deleteAllCustomers();
    }

    @Override
    public Optional<Customer> findCustomerByEmail(String email) {

        return customerRepository.findByEmail(email);
    }
}
