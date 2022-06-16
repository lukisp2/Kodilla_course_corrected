package com.kodilla.hibernate.manytomany.facade;

public class FacadeException extends Exception {
    public static String COMPANY_NOT_FOUND = "Company not found -> no such company in database";
    public static String EMPLOYEE_NOT_FOUND = "Employee not found -> no such employee in database";

    public FacadeException(String message) {
        super(message);

    }
}
