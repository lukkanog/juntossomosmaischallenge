package spo.ifsp.edu.br.juntossomosmaischallenge.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.UserService;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces.IUserService;

@Configuration
public class AppConfig {
    @Bean
    public IUserService userService() {
        return new UserService();
    }
}
