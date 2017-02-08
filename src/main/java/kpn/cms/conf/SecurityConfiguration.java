package kpn.cms.conf;

/**
 * Created by rosgupta on 2/8/17.
 */
        import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http
                    .httpBasic()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/index.html", "/", "/login", "/message", "/home").permitAll()
                    .anyRequest().authenticated();
            // @formatter:on
        }
}