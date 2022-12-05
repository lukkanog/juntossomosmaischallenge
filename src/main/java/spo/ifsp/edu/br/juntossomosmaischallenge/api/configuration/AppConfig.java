package spo.ifsp.edu.br.juntossomosmaischallenge.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spo.ifsp.edu.br.juntossomosmaischallenge.service.RegionService;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.UserService;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.UserTypeService;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces.IRegionService;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces.IUserService;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces.IUserTypeService;

@Configuration
public class AppConfig {
    @Bean
    public IUserService userService() {
        return new UserService();
    }

    @Bean
    public IUserTypeService userTypeService() {
        return new UserTypeService();
    }

    @Bean 
    public IRegionService regionService() {
        return new RegionService();
    }
}
