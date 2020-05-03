package com.skolamaric.dao;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.skolamaric.exceptions.dao.ResultNotFoundException;
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
	public Student read(String brojIndeksa) throws ResultNotFoundException {

		Student student = upisaniStudenti.get(brojIndeksa);
		if (student == null) {
			throw new ResultNotFoundException("Objekat nije pronadjen");
		}
		return student;
	}

	@Override
	public Student update(Student student) {
		upisaniStudenti.put(student.getBrojIndeksa(), student);
		return student;
	}

	@Override
	public void delete(String brojIndeksa) {
		upisaniStudenti.remove(brojIndeksa);

	}

	private String brojIndeksa() {

		int broj = (int) (Math.random() * ((KONSTANTE.MAX_BROJ_ZA_INDEKS - KONSTANTE.MIN_BROJ_ZA_INDEKS) + 1))
				+ KONSTANTE.MIN_BROJ_ZA_INDEKS;
		String randomBrojIndeksa = KONSTANTE.slucajnoSlovo() + broj;
		if (StudentInMemoryDAOImpl.upisaniStudenti.containsKey(randomBrojIndeksa)) {
			System.out.println("DUPLIKAT  " + randomBrojIndeksa);
			return brojIndeksa();
		}
		StudentInMemoryDAOImpl.upisaniStudenti.put(randomBrojIndeksa, null);
		return randomBrojIndeksa;
	}

	@Override
	public int count() {
		return StudentInMemoryDAOImpl.upisaniStudenti.keySet().size();

	}

	@Override
	public List<Student> getAll() throws ResultNotFoundException {
		return StudentInMemoryDAOImpl.upisaniStudenti.values().stream().collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentiPrveGodine() {
		// TODO Auto-generated method stub
		return StudentInMemoryDAOImpl.upisaniStudenti.values().stream().filter(s -> s.getGodinaFakulteta() == 1)
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentiDrugeGodine() {
		// TODO Auto-generated method stub
		return StudentInMemoryDAOImpl.upisaniStudenti.values().stream().filter(s -> s.getGodinaFakulteta() == 2)
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentiTreceGodine() {
		// TODO Auto-generated method stub
		return StudentInMemoryDAOImpl.upisaniStudenti.values().stream().filter(s -> s.getGodinaFakulteta() == 3)
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentiCetvrteGodine() {
		// TODO Auto-generated method stub
		return StudentInMemoryDAOImpl.upisaniStudenti.values().stream().filter(s -> s.getGodinaFakulteta() == 4)
				.collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentiApsolventi() {
		// TODO Auto-generated method stub
		return StudentInMemoryDAOImpl.upisaniStudenti.values().stream().filter(s -> s.getGodinaFakulteta() > 1)
				.collect(Collectors.toList());
	}
}
