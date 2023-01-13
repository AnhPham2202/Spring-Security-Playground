package na.pham.securityapp.repository;

import na.pham.securityapp.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByEmail(String email);
}
