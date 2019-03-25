package com.usa.gov.ssn.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.gov.ssn.entity.ApplicationEntity;
@Repository
public interface ApplicationRegRepository extends JpaRepository<ApplicationEntity, Serializable> {

}
