package com.kodilla.hibernate.manytomany;

import com.sun.istack.NotNull;
import jdk.jfr.Name;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NamedQuery(
        name = "Employee.retrieveEmployeesBySpecificLastName",
        query = "FROM Employee WHERE lastname =:LASTNAME"
)
@NamedQuery(
        name = "Employee.retrieveEmployeesByPartOfName",
        query = "FROM Employee WHERE lastname LIKE : ARG"
)
@Entity
@Table(name = "EMPLOYESS")
public class Employee {
    private int id;
    private String firstname;
    private String lastname;
    private List<Company> companies = new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "FIRSTNAME")
    public String getFirstname() {
        return firstname;
    }

    @Column(name = "LASTNAME")
    public String getLastname() {
        return lastname;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID",referencedColumnName = "COMPANY_ID")}
    )
    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
//