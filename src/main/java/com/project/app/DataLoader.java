package com.project.app;

import com.project.app.model.Employee;
import com.project.app.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) {
        employeeRepository.save(new Employee("Alice", "Johnson", "Engineering", 95000));
        employeeRepository.save(new Employee("Bob", "Smith", "Engineering", 88000));
        employeeRepository.save(new Employee("Carol", "Williams", "Engineering", 102000));
        employeeRepository.save(new Employee("David", "Brown", "Engineering", 91000));
        employeeRepository.save(new Employee("Eve", "Jones", "Engineering", 87000));
        employeeRepository.save(new Employee("Frank", "Garcia", "Marketing", 72000));
        employeeRepository.save(new Employee("Grace", "Martinez", "Marketing", 68000));
        employeeRepository.save(new Employee("Henry", "Davis", "Marketing", 75000));
        employeeRepository.save(new Employee("Iris", "Lopez", "Marketing", 71000));
        employeeRepository.save(new Employee("Jack", "Wilson", "Marketing", 69000));
        employeeRepository.save(new Employee("Karen", "Anderson", "HR", 65000));
        employeeRepository.save(new Employee("Leo", "Thomas", "HR", 63000));
        employeeRepository.save(new Employee("Mia", "Taylor", "HR", 67000));
        employeeRepository.save(new Employee("Noah", "Jackson", "HR", 64000));
        employeeRepository.save(new Employee("Olivia", "White", "HR", 66000));
        employeeRepository.save(new Employee("Paul", "Harris", "Finance", 85000));
        employeeRepository.save(new Employee("Quinn", "Martin", "Finance", 89000));
        employeeRepository.save(new Employee("Rachel", "Thompson", "Finance", 92000));
        employeeRepository.save(new Employee("Sam", "Garcia", "Finance", 86000));
        employeeRepository.save(new Employee("Tina", "Robinson", "Finance", 83000));
        employeeRepository.save(new Employee("Uma", "Clark", "Legal", 98000));
        employeeRepository.save(new Employee("Victor", "Lewis", "Legal", 105000));
        employeeRepository.save(new Employee("Wendy", "Lee", "Legal", 97000));
        employeeRepository.save(new Employee("Xander", "Walker", "Legal", 101000));
        employeeRepository.save(new Employee("Yara", "Hall", "Legal", 99000));
    }
}