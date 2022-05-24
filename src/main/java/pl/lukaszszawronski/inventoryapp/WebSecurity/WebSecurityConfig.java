package pl.lukaszszawronski.inventoryapp.WebSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user1 = User
                .withUsername("jan")
                .password("$2a$10$KGLmqh6g6T3Io7XeLR5ICOx1lJKj2VtwP8AwJpZpR1GhYf8yjnmJy")
                .roles("USER")
                .build();

        UserDetails user2 = User
                .withUsername("admin")
                .password("$2a$10$QYJ3Kn5/.4IpAuFVY5gUC.jgs8n2WU88yutqO01JrYEMHLhwQRgQy")
                .roles("ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(user1, user2);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
              .authorizeRequests()
              .antMatchers("/")
              .permitAll()
              .antMatchers("/categories/new", "/products/new", "/brands/new").hasRole("ADMIN")
              .anyRequest()
              .authenticated()
              .and()
              .formLogin()
              .loginPage("/login")
              .permitAll()
              .and()
              .logout()
              .permitAll();
    }
}
