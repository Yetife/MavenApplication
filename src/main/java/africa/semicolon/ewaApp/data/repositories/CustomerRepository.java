package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);

    void delete(Customer customer);

    void delete(String email);

    Optional<Customer> findByEmail(String email);

    List<Customer> findAll();

    void deleteAllCustomers();

}
