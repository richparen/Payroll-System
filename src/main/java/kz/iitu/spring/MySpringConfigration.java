package kz.iitu.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("kz.iitu.spring")
@PropertySource("/application.properties")
public class MySpringConfigration { }
