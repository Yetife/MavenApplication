package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Customer;

import java.util.*;

public class CustomerRepositoryImpl implements CustomerRepository {
    Map<String, Customer> database = new HashMap<>();
    @Override
    public Customer save(Customer customer) {
        database.put(customer.getEmail(), customer);
        return customer;
    }

    @Override
    public void delete(Customer customer) {
        delete(customer.getEmail());
    }

    @Override
    public void delete(String email) {
        database.remove(email);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        if(database.containsKey(email)){
            return Optional.of(database.get(email));
        }
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> allCustomers = new ArrayList<>();
        Set<String> keysInDB = database.keySet();
        for(String key : keysInDB) {
            allCustomers.add(database.get(key));
        }
        return allCustomers;
    }

    @Override
    public void deleteAllCustomers() {
        database.clear();
    }
}
