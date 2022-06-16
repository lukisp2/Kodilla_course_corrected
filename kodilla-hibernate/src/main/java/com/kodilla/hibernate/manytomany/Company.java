package com.kodilla.hibernate.manytomany;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NamedNativeQuery(
        name = "Company.retrieveCompanysByFirstThreeLettersOfCompanyName",
        query = "SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE :STR",
        resultClass = Company.class
)
@NamedQuery(
        name = "Company.retrieveCompanyByPartOfCompanyName",
        query = "FROM Company WHERE name LIKE :ARG"
)
@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "companies"
    )
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
