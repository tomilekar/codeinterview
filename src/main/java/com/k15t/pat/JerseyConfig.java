package com.k15t.pat;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;


@Configuration
public class JerseyConfig extends ResourceConfig {

    private final ApplicationContext applicationContext;

    public JerseyConfig (ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @PostConstruct
    public void registerResourcesAndProviders () {
        applicationContext.getBeansWithAnnotation(Path.class).values().forEach(this::register);
    }

}
