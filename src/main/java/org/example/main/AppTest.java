package org.example.main;

import org.example.beans.repository.EmployeeRepository;
import org.example.config.AppConfig;
import org.example.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class AppTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");

        String beansNames[] = context.getBeanDefinitionNames();

        System.out.println(Arrays.toString(beansNames));


        EmployeeRepository repository = context.getBean(EmployeeRepository.class);

        // delete
        repository.delete("uid-12345");

        // update
        Employee e2 = new Employee();
        e2.setUid("uid-123456");
        e2.setFirstName("f1");
        repository.update(e2);

        // insert
        Employee e1 = new Employee();
        e1.setUid(UUID.randomUUID().toString());
        e1.setFirstName("f1");
        e1.setLastName("l1");
        repository.insert(e1);

        // select by UID
        Employee e = repository.selectByUid("uid-123456");
        System.out.println(e.getFirstName());

        // select all
        List<Employee> employees = repository.selectAll();
        System.out.println(employees);
    }
}
