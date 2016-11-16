package com.crossover.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.crossover.spring.dao.GenericDao;
import com.crossover.spring.dao.ParameterDao;
import com.crossover.spring.model.Parameter;
import com.crossover.spring.model.ParameterId;

@Service
public class ParameterServiceImpl extends GenericServiceImpl<Parameter, ParameterId> implements parameterService {

	private ParameterDao parameterDao;
	
	public ParameterServiceImpl(){}
	
	@Autowired
	public ParameterServiceImpl(
			@Qualifier("parameterDaoImpl") GenericDao<Parameter, ParameterId> genericDao){
		super(genericDao);
		this.parameterDao = (ParameterDao) genericDao;
	}

}
