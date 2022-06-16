package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import java.util.List;


@Service
public class Facade {
    private final EmployeeDao employeeDao;
    private final CompanyDao companyDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(Facade.class);

    @Autowired
    public Facade(EmployeeDao employeeDao, CompanyDao companyDao) {
        this.employeeDao = employeeDao;
        this.companyDao = companyDao;
    }


    public List<Employee> findEmployee(String str) throws FacadeException {
        LOGGER.info("Trying to find employee by name containing: " + str);
        str = "%" + str + "%";
        List<Employee> employees = employeeDao.retrieveEmployeesByPartOfName(str);
        if (employees.size() < 1) {
            LOGGER.warn(FacadeException.EMPLOYEE_NOT_FOUND);
            throw new FacadeException(FacadeException.EMPLOYEE_NOT_FOUND);
        }
        return employees;
    }

    public List<Company> findCompanies(String str) throws FacadeException {
        LOGGER.info("Trying to find company by name containing: " + str);
        str = "%" + str + "%";
        List<Company> companies = companyDao.retrieveCompanyByPartOfCompanyName(str);
        if (companies.size() < 1) {
            LOGGER.warn(FacadeException.COMPANY_NOT_FOUND);
            throw new FacadeException(FacadeException.COMPANY_NOT_FOUND);
        }
        return companies;
    }
}
