package na.pham.securityapp.controller;

import na.pham.securityapp.entity.Customer;
import na.pham.securityapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogInController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
