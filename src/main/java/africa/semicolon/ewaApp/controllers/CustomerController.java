package africa.semicolon.ewaApp.controllers;

import africa.semicolon.ewaApp.data.models.Customer;
import africa.semicolon.ewaApp.dtos.requests.CustomerRequest;
import africa.semicolon.ewaApp.dtos.responses.CustomerResponse;
import africa.semicolon.ewaApp.exceptions.CustomerNotFoundException;
import africa.semicolon.ewaApp.services.CustomerService;
import africa.semicolon.ewaApp.services.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    @PostMapping("/api/customer")
    public ResponseEntity<?> register(@RequestBody CustomerRequest customerRequest) {
//        return customerService.register(customerRequest);
        try{
            CustomerResponse response = customerService.register(customerRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(CustomerNotFoundException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable("id") String email) {
        return customerService.findCustomerByEmail(email);

    }
}
