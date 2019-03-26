package com.usa.gov.ssn.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usa.gov.ssn.entity.StateEntity;

public interface StatesRepository extends JpaRepository<StateEntity, Serializable> {

}
