package com.tech.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.dto.Result;

@Repository
public interface Resultdao extends JpaRepository<Result, Integer> {

	

}
