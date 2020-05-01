package com.skolamaric.dao;

import java.util.HashMap;

import com.skolamaric.model.Student;
import com.skolamaric.utils.KONSTANTE;

public class StudentInMemoryDAOImpl implements StudentDAO {
	private static final HashMap<String, Student> upisaniStudenti = new HashMap<String, Student>();

	@Override
	public Student create(Student student) {
		String brojIndeksa = brojIndeksa();
		student.setBrojIndeksa(brojIndeksa);
		upisaniStudenti.put(student.getBrojIndeksa(), student);
		return student;
	}

	@Override
	public Student read(String brojIndeksa) {

		return upisaniStudenti.get(brojIndeksa);
	}

	@Override
	public Student update(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub

	}

	private String brojIndeksa() {

		int broj = (int) (Math.random() * ((KONSTANTE.MAX_BROJ_ZA_INDEKS - KONSTANTE.MIN_BROJ_ZA_INDEKS) + 1))
				+ KONSTANTE.MIN_BROJ_ZA_INDEKS;
		String randomBrojIndeksa = KONSTANTE.slucajnoSlovo() + broj;
		  if (StudentInMemoryDAOImpl.upisaniStudenti.containsKey(randomBrojIndeksa)) {
			System.out.println("DUPLIKAT" + randomBrojIndeksa);
			return brojIndeksa();
		  }
		StudentInMemoryDAOImpl.upisaniStudenti.put(randomBrojIndeksa, null);
		return randomBrojIndeksa;
	}

	@Override
	public int count() {
		return StudentInMemoryDAOImpl.upisaniStudenti.keySet().size();

	}

}
