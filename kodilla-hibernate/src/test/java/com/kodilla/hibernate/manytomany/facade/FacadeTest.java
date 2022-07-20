package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FacadeTest {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private Facade facade;


    @Test
    void testEmployeesByNamePart() throws FacadeException {
        //Given
        Employee johnSmith = new Employee("Johny", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Calrckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalski");
        //When
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        //Then

        List<Employee> employeeList = facade.findEmployee("ith");
        assertEquals(1, employeeList.size());

        //CleanUp
        employeeDao.deleteAll();
    }

    @Test
    void testCompaniesByNamePart() {
        //Given
        Company softwareMachine = new Company("Software Machines");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        //When
        companyDao.save(softwareMachine);
        companyDao.save(dataMasters);
        companyDao.save(greyMatter);

        //Then
        List<Company> companiesByPartOfName = companyDao
                .retrieveCompanyByPartOfCompanyName("ware");

        assertEquals(1,companiesByPartOfName.size());

        //CleanUp
        companyDao.deleteAll();
    }
}
