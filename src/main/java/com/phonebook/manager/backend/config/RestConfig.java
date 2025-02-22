package com.phonebook.manager.backend.config;

import com.phonebook.manager.backend.Entity.Contact;
import com.phonebook.manager.backend.Entity.User;
import com.phonebook.manager.backend.constant.AppConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig {
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer(){
            return new RepositoryRestConfigurer() {
                @Override
                public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
                        config.setBasePath(AppConstants.API_BASEPATH);
                        config.setDefaultPageSize(AppConstants.PAGE_SIZE);
                        config.setDefaultMediaType(MediaType.APPLICATION_JSON);
                        config.exposeIdsFor(User.class, Contact.class);
                }
            };
    }


}
