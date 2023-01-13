package na.pham.securityapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain config(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .requestMatchers("/account", "/loan", "/balance", "/card").authenticated()
                .requestMatchers("/notice", "/contact", "/register").permitAll()
                        .and().formLogin()
                        .and().httpBasic()
                .and()
                .csrf().disable().build();
    }

//    @Bean
//    InMemoryUserDetailsManager defineUser() {
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("admin")
//                .build();
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .roles("read")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }

//    @Bean
//    public UserDetailsService jdbcUserDetailsManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
