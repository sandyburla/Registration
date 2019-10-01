package com.sandeep.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sandeep.login.model.Register;


public interface LoginAndRegisterDao extends JpaRepository<Register, Integer> {


}
