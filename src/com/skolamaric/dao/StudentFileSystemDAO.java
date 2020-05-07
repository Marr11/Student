package com.skolamaric.dao;

import java.util.List;

import com.skolamaric.exceptions.dao.ResultNotFoundException;
import com.skolamaric.model.Student;

public class StudentFileSystemDAO implements StudentDAO {

	@Override
	public Student create(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student read(String brojIndeksa) throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student update(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String brojIndeksa) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> getAll() throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentiPrveGodine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentiDrugeGodine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentiTreceGodine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentiCetvrteGodine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentiApsolventi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
