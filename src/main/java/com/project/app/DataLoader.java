package com.project.app;

import com.project.app.model.Employee;
import com.project.app.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;


    @Override
    public void run(String... args) {
        Employee employee001=Employee.builder()
                .firstName("Alice")
                .lastName("Johnson")
                .department("Engineering")
                .salary(95000.0)
                .build();
        Employee employee002=Employee.builder()
                .firstName("Bob")
                .lastName("Smith")
                .department("Engineering")
                .salary(88000.0)
                .build();

        Employee employee003 = Employee.builder()
                .firstName("Carol")
                .lastName("Williams")
                .department("Engineering")
                .salary(102000.0)
                .build();

        Employee employee004 = Employee.builder()
                .firstName("David")
                .lastName("Brown")
                .department("Engineering")
                .salary(91000.0)
                .build();

        Employee employee005 = Employee.builder()
                .firstName("Eve")
                .lastName("Jones")
                .department("Engineering")
                .salary(87000.0)
                .build();

        Employee employee006 = Employee.builder()
                .firstName("Frank")
                .lastName("Garcia")
                .department("Marketing")
                .salary(72000.0)
                .build();

        Employee employee007 = Employee.builder()
                .firstName("Grace")
                .lastName("Martinez")
                .department("Marketing")
                .salary(68000.0)
                .build();

        Employee employee008 = Employee.builder()
                .firstName("Henry")
                .lastName("Davis")
                .department("Marketing")
                .salary(75000.0)
                .build();

        Employee employee009 = Employee.builder()
                .firstName("Iris")
                .lastName("Lopez")
                .department("Marketing")
                .salary(71000.0)
                .build();

        Employee employee010 = Employee.builder()
                .firstName("Jack")
                .lastName("Wilson")
                .department("Marketing")
                .salary(69000.0)
                .build();

        Employee employee011 = Employee.builder()
                .firstName("Karen")
                .lastName("Anderson")
                .department("HR")
                .salary(65000.0)
                .build();

        Employee employee012 = Employee.builder()
                .firstName("Leo")
                .lastName("Thomas")
                .department("HR")
                .salary(63000.0)
                .build();

        Employee employee013 = Employee.builder()
                .firstName("Mia")
                .lastName("Taylor")
                .department("HR")
                .salary(67000.0)
                .build();

        Employee employee014 = Employee.builder()
                .firstName("Noah")
                .lastName("Jackson")
                .department("HR")
                .salary(64000.0)
                .build();

        Employee employee015 = Employee.builder()
                .firstName("Olivia")
                .lastName("White")
                .department("HR")
                .salary(66000.0)
                .build();

        Employee employee016 = Employee.builder()
                .firstName("Paul")
                .lastName("Harris")
                .department("Finance")
                .salary(85000.0)
                .build();

        Employee employee017 = Employee.builder()
                .firstName("Quinn")
                .lastName("Martin")
                .department("Finance")
                .salary(89000.0)
                .build();

        Employee employee018 = Employee.builder()
                .firstName("Rachel")
                .lastName("Thompson")
                .department("Finance")
                .salary(92000.0)
                .build();

        Employee employee019 = Employee.builder()
                .firstName("Sam")
                .lastName("Garcia")
                .department("Finance")
                .salary(86000.0)
                .build();

        Employee employee020 = Employee.builder()
                .firstName("Tina")
                .lastName("Robinson")
                .department("Finance")
                .salary(83000.0)
                .build();

        Employee employee021 = Employee.builder()
                .firstName("Uma")
                .lastName("Clark")
                .department("Legal")
                .salary(98000.0)
                .build();

        Employee employee022 = Employee.builder()
                .firstName("Victor")
                .lastName("Lewis")
                .department("Legal")
                .salary(105000.0)
                .build();

        Employee employee023 = Employee.builder()
                .firstName("Wendy")
                .lastName("Lee")
                .department("Legal")
                .salary(97000.0)
                .build();

        Employee employee024 = Employee.builder()
                .firstName("Xander")
                .lastName("Walker")
                .department("Legal")
                .salary(101000.0)
                .build();

        Employee employee025 = Employee.builder()
                .firstName("Yara")
                .lastName("Hall")
                .department("Legal")
                .salary(99000.0)
                .build();
        employeeRepository.save(employee001);
        employeeRepository.save(employee002);
        employeeRepository.save(employee003);
        employeeRepository.save(employee004);
        employeeRepository.save(employee005);
        employeeRepository.save(employee006);
        employeeRepository.save(employee007);
        employeeRepository.save(employee008);
        employeeRepository.save(employee009);
        employeeRepository.save(employee010);
        employeeRepository.save(employee011);
        employeeRepository.save(employee012);
        employeeRepository.save(employee013);
        employeeRepository.save(employee014);
        employeeRepository.save(employee015);
        employeeRepository.save(employee016);
        employeeRepository.save(employee017);
        employeeRepository.save(employee018);
        employeeRepository.save(employee019);
        employeeRepository.save(employee020);
        employeeRepository.save(employee021);
        employeeRepository.save(employee022);
        employeeRepository.save(employee023);
        employeeRepository.save(employee024);
        employeeRepository.save(employee025);
    }
}