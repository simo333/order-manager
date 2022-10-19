package com.simo333.spring.projects.ordersmanager;

import com.simo333.spring.projects.ordersmanager.model.Employee;
import com.simo333.spring.projects.ordersmanager.model.FurnitureType;
import com.simo333.spring.projects.ordersmanager.model.JobPosition;
import com.simo333.spring.projects.ordersmanager.model.Model;
import com.simo333.spring.projects.ordersmanager.service.EmployeeService;
import com.simo333.spring.projects.ordersmanager.service.FurnitureTypeService;
import com.simo333.spring.projects.ordersmanager.service.JobPositionService;
import com.simo333.spring.projects.ordersmanager.service.ModelService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class OrdersManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ModelService modelService, FurnitureTypeService furnitureTypeService,
                          JobPositionService jobPositionService, EmployeeService employeeService) {
        JobPosition position1 = new JobPosition();
        position1.setName("Tapicer");
        JobPosition position2 = new JobPosition();
        position2.setName("Piankarz");
        JobPosition position3 = new JobPosition();
        position3.setName("Szwaczka");
        List<JobPosition> jobPositionList = List.of(position1, position2, position3);
        jobPositionList.forEach(jobPositionService::save);

        FurnitureType type1 = new FurnitureType();
        type1.setName("Sofa");
        FurnitureType type2 = new FurnitureType();
        type2.setName("Wersalka");
        FurnitureType type3 = new FurnitureType();
        type3.setName("Narożnik");
        FurnitureType type4 = new FurnitureType();
        type4.setName("Fotel");
        FurnitureType type5 = new FurnitureType();
        type5.setName("Łóżko sypialniane");
        List<FurnitureType> typeList = List.of(type1, type2, type3, type4, type5);
        typeList.forEach(furnitureTypeService::save);

        IntStream.rangeClosed(1, 20).forEach(i -> {
            Employee employee = new Employee();
            employee.setName("Imię" + i);
            employee.setLastName("Nazwisko" + i);
            employee.setDateOfBirth(LocalDate.of(1980 + i, Month.DECEMBER, 2 + i));
            employee.setStreet("ul. Leśna 2");
            employee.setCity("Gębice");
            employee.setZipCode("88-330");
            employee.setCountry("Polska");
            employee.setPhoneNumber("123456789");
            employee.setContractBeginning(LocalDate.of(2020, Month.APRIL, 2));
            employee.setContractExpiration(LocalDate.now().plusMonths(12));
            employee.setJobPosition(jobPositionService.getOne(1L));
            employeeService.save(employee);
        });

        return args -> IntStream.rangeClosed(1, 100).forEach(i -> {
            Model model = new Model();
            model.setName("Model" + i);
            model.setInnerName("InnerName" + i);
            model.setType(furnitureTypeService.getOne(1L));
            modelService.save(model);
        });
    }

}
