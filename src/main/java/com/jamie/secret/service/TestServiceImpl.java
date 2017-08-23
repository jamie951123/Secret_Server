package com.jamie.secret.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamie.secret.dao.TestDao;
import com.jamie.secret.model.TestModel;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDao testDao;
	
	@Override
	public List<TestModel> findAll() {
		// TODO Auto-generated method stub
		return testDao.findAll();
	}

}
