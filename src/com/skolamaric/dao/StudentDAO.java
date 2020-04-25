package com.skolamaric.dao;

import com.skolamaric.model.Student;

public interface StudentDAO {
	
	Student create (Student student);
	Student read (String brojIndeksa);
	Student update (Student student);
	void delete (Student student);
}
