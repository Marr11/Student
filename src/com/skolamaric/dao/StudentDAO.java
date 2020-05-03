package com.skolamaric.dao;

import java.util.List;

import com.skolamaric.exceptions.dao.ResultNotFoundException;
import com.skolamaric.model.Student;

public interface StudentDAO {
	
	Student create (Student student);
	Student read (String brojIndeksa) throws ResultNotFoundException;
	Student update (Student student);
	void delete (String brojIndeksa);
	List<Student> getAll() throws ResultNotFoundException;
	int count();
}
