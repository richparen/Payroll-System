package kz.iitu.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySpringConfigration.class);
        PayrollSystem payrollSystem = context.getBean("PayrollSystem", PayrollSystem.class);
        payrollSystem.start();

        context.registerShutdownHook();

    }

}
