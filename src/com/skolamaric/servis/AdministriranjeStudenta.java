package com.skolamaric.servis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.skolamaric.dao.StudentDAO;
import com.skolamaric.dao.StudentInMemoryDAOImpl;
import com.skolamaric.exceptions.dao.ResultNotFoundException;
import com.skolamaric.model.Student;
import com.skolamaric.utils.KONSTANTE;

public class AdministriranjeStudenta {

	private StudentInMemoryDAOImpl studentDAO;

	public AdministriranjeStudenta() {
		studentDAO = new StudentInMemoryDAOImpl();
	}

	public List<Student> generisanje() {
		List<Student> studenti = new ArrayList<Student>();
		try {
		
		Student zadnjiUpisaniStudent = null;
		
		for (int i = 0; i < 100; i++) {
			String brojIndeksa = "";
			Student student = new Student(brojIndeksa);
			student.setIme(KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo());
			student.setPrezime(KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo());
			student.setGodinaFakulteta(godinaStudija());
			student.setAktivanStudent(true);
			zadnjiUpisaniStudent = studentDAO.create(student);

		}
		System.out.println("Upisanih studenta: " + studentDAO.count());
		System.out.println("Poslednji upisani student: " + zadnjiUpisaniStudent.getBrojIndeksa() + ", godina studija: "
				+ studentDAO.read(zadnjiUpisaniStudent.getBrojIndeksa()).isAktivanStudent());
		zadnjiUpisaniStudent.setAktivanStudent(!zadnjiUpisaniStudent.isAktivanStudent());
		zadnjiUpisaniStudent = studentDAO.update(zadnjiUpisaniStudent);
		System.out.println("Poslednji upisani student: " + zadnjiUpisaniStudent.getBrojIndeksa() + ", godina studija: "
				+ studentDAO.read(zadnjiUpisaniStudent.getBrojIndeksa()).isAktivanStudent());
		studenti = studentDAO.getAll();
		studentDAO.delete(zadnjiUpisaniStudent.getBrojIndeksa());
		
			zadnjiUpisaniStudent = studentDAO.read(zadnjiUpisaniStudent.getBrojIndeksa());
			
		} catch (ResultNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("OBRISAN!!!");
		}
		
		/*if(zadnjiUpisaniStudent !=null) {
		System.out.println("Poslednji upisani student: " + zadnjiUpisaniStudent.getBrojIndeksa() + ", godina studija: "
			+ studentDAO.read(zadnjiUpisaniStudent.getBrojIndeksa()).isAktivanStudent());
		}
		else {
			System.out.println("OBRISAN!!!");
		}*/
	
		return studenti;
	}

	/*
	 * Metoda za slucajan odabir godine studija return broj
	 */
	private int godinaStudija() {
		int broj;
		broj = (int) (Math.random() * ((KONSTANTE.MAX_BROJ_GODINE_STUDIJA - KONSTANTE.MIN_BROJ_GODINE_STUDIJA) + 1))
				+ KONSTANTE.MIN_BROJ_GODINE_STUDIJA;

		return broj;
	}

	/*
	 * Metoda za odvajanje liste studenata prve godine 
	 * return List studenti prve
	 * godine
	 */
	public static List<Student> studentiPrveGodine(List<Student> studenti) {
		List<Student> student1 = studenti.stream().filter(s -> s.getGodinaFakulteta() == 1)
				.collect(Collectors.toList());
		return student1;

	}

	/*
	 * Metoda za odvajanje liste studenata druge godine 
	 * return List studenti druge
	 * godine
	 */
	public static List<Student> studentiDrugeGodine(List<Student> studenti) {
		List<Student> student2 = studenti.stream().filter(s -> s.getGodinaFakulteta() == 2)
				.collect(Collectors.toList());
		return student2;

	}

	/*
	 * Metoda za odvajanje liste studenata trece godine 
	 * return List studenti trece
	 * godine
	 */
	public static List<Student> studentiTreceGodine(List<Student> studenti) {
		List<Student> student3 = studenti.stream().filter(s -> s.getGodinaFakulteta() == 3)
				.collect(Collectors.toList());
		return student3;

	}

	/*
	 * Metoda za odvajanje liste studenata cetvrte godine 
	 * return List studenti trece
	 * godine
	 */
	public static List<Student> studentiCetvrteGodine(List<Student> studenti) {
		List<Student> student4 = studenti.stream().filter(s -> s.getGodinaFakulteta() == 4)
				.collect(Collectors.toList());
		return student4;

	}

	/*
	 * Metoda za odvajanje liste apsolvenata 
	 * return List apsolventi
	 */
	public static List<Student> studentiApsolventi(List<Student> studenti) {
		List<Student> student5 = studenti.stream().filter(s -> s.getGodinaFakulteta() > 4).collect(Collectors.toList());
		return student5;
	}

}
