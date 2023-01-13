package na.pham.securityapp.config;

import na.pham.securityapp.entity.Customer;
import na.pham.securityapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EazyBankUserDetails implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName = null;
        String password = null;
        List<GrantedAuthority> authorities = null;
        Customer customer = customerRepository.findByEmail(username);

        if (Objects.isNull(customer)) {
            throw new UsernameNotFoundException("Not found");
        } else {
            userName = customer.getEmail();
            password = customer.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.getRole()));
        }

        return new User(username, password, authorities);
    }
}
