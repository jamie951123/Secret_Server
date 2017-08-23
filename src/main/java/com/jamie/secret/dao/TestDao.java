package com.jamie.secret.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jamie.secret.model.TestModel;

public interface TestDao extends JpaRepository<TestModel,Long> {

	List<TestModel> findAll();
}
