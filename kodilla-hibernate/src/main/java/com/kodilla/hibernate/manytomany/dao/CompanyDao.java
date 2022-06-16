package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyDao extends CrudRepository<Company,Integer> {
    @Query(nativeQuery = true)
    List<Company> retrieveCompanyByFirstThreeLettersOfCompanyName(@Param("STR") String str);
    List<Company> retrieveCompanyByPartOfCompanyName(@Param("ARG") String arg);

}
