package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Calrckson");
        Employee lindaKovalsky = new Employee("Linda","Kovalski");

        Company softwareMachine = new Company("Software Machines");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMasters.getEmployees().add(stephanieClarckson);
        dataMasters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);

        companyDao.save(softwareMachine);
        int softWareMachineId = softwareMachine.getId();
        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0,softWareMachineId);
        assertNotEquals(0,dataMastersId);
        assertNotEquals(0,greyMatterId);

        //CleanUp
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }

    void testEmployessByName() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Calrckson");
        Employee lindaKovalsky = new Employee("Linda","Kovalski");
        //When
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        //Then
        List<Employee> employeesByName = employeeDao.
                retrieveEmployeesBySpecificLastName("Smith");
        assertEquals(1,employeesByName.size());
        //CleanUp
        employeeDao.deleteAll();
    }
    void testCompaniesByFirstThreeLetters() {
        //Given
        Company softwareMachine = new Company("Software Machines");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        //When
        companyDao.save(softwareMachine);
        companyDao.save(dataMasters);
        companyDao.save(greyMatter);

        //Then
        List<Company> companiesByFirstThreeLetters = companyDao
                .retrieveCompanysByFirstThreeLettersOfCompanyName("Sof");
        assertEquals(1,companiesByFirstThreeLetters.size());

        //CleanUp
        companyDao.deleteAll();
    }
}
