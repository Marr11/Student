package com.skolamaric.servis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.skolamaric.dao.StudentDAO;
import com.skolamaric.dao.StudentInMemoryDAOImpl;
import com.skolamaric.model.Student;
import com.skolamaric.utils.KONSTANTE;

public class AdministriranjeStudenta {

	private StudentInMemoryDAOImpl studentDAO;

	public AdministriranjeStudenta() {
		studentDAO = new StudentInMemoryDAOImpl();
	}

	public List<Student> generisanje() {
		List<Student> studenti = new ArrayList<Student>();
		Student zadnjiUpisaniStudent = null;
		for (int i = 0; i < 100; i++) {
			String brojIndeksa = "";
			Student student = new Student(brojIndeksa);
			student.setIme(KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo());
			student.setPrezime(KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo());
			student.setGodinaFakulteta(godinaStudija());
			student.setAktivanStudent(true);
			studenti.add(student);
			zadnjiUpisaniStudent = studentDAO.create(student);

		}
		System.out.println("Upisanih studenta: " + studentDAO.count());
		System.out.println("Poslednji upisani student: "+ zadnjiUpisaniStudent.getBrojIndeksa() 
		                    + ", godina studija: "+  studentDAO.read(zadnjiUpisaniStudent.getBrojIndeksa()).isAktivanStudent());
		zadnjiUpisaniStudent.setAktivanStudent(!zadnjiUpisaniStudent.isAktivanStudent());
		zadnjiUpisaniStudent = studentDAO.update(zadnjiUpisaniStudent);
		System.out.println("Poslednji upisani student: "+ zadnjiUpisaniStudent.getBrojIndeksa() 
        + ", godina studija: "+  studentDAO.read(zadnjiUpisaniStudent.getBrojIndeksa()).isAktivanStudent());
		return studenti;
	}

	private int godinaStudija() {
		// random broj za godinu fakulteta, ali od 1-5
		int broj;
		broj = (int) (Math.random() * ((KONSTANTE.MAX_BROJ_GODINE_STUDIJA - KONSTANTE.MIN_BROJ_GODINE_STUDIJA) + 1))
				+ KONSTANTE.MIN_BROJ_GODINE_STUDIJA;

		return broj;
	}

	public static List<Student> studentiPrveGodine(List<Student> studenti) {
		List<Student> student1 = studenti.stream().filter(s -> s.getGodinaFakulteta() == 1)
				.collect(Collectors.toList());
		return student1;

	}

	public static List<Student> studentiDrugeGodine(List<Student> studenti) {
		List<Student> student2 = studenti.stream().filter(s -> s.getGodinaFakulteta() == 2)
				.collect(Collectors.toList());
		return student2;

	}

	public static List<Student> studentiTreceGodine(List<Student> studenti) {
		List<Student> student3 = studenti.stream().filter(s -> s.getGodinaFakulteta() == 3)
				.collect(Collectors.toList());
		return student3;

	}

	public static List<Student> studentiCetvrteGodine(List<Student> studenti) {
		List<Student> student4 = studenti.stream().filter(s -> s.getGodinaFakulteta() == 4)
				.collect(Collectors.toList());
		return student4;

	}

	public static List<Student> studentiApsolventi(List<Student> studenti) {
		List<Student> student5 = studenti.stream().filter(s -> s.getGodinaFakulteta() > 4).collect(Collectors.toList());
		return student5;
	}

}
