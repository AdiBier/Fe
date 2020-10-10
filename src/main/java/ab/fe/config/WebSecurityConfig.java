package ab.fe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(16);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf()
        .disable()
        .authorizeRequests()
        .antMatchers(
            "/static/**",
            "/static/css/**",
            "/static/favicon.ico",
            "/**/*.css",
            "/customers/**",
            "/api/customers/**")
        .permitAll()
        .antMatchers(
            "/home",
            "/",
            "/api/users/**",
            "/api/admin/**")
        .access("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_ADMIN')")
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
            .loginPage("/my-login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
        .permitAll()
        .and()
            .logout()
        .permitAll();
  }
}
