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

public class AdministriranjeStudenata {

	private StudentInMemoryDAOImpl studentDAO;

	public AdministriranjeStudenata() {
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
			zadnjiUpisaniStudent = studentDAO.read(zadnjiUpisaniStudent.getBrojIndeksa());
			System.out.println("Poslednji upisani student " + zadnjiUpisaniStudent);
		} catch (ResultNotFoundException e) {

			System.out.println(e.getMessage());
			System.out.println("OBRISAN!!!");
		}

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

	public List<Student> dajSveStudente() throws ResultNotFoundException {
		return studentDAO.getAll();
	}

	/*
	 * Metoda za odvajanje liste studenata prve godine return List studenti prve
	 * godine
	 */
	public List<Student> studentiPrveGodine() {
		List<Student> student1 = studentDAO.getStudentiPrveGodine();
		return student1;

	}

	/*
	 * Metoda za odvajanje liste studenata druge godine return List studenti druge
	 * godine
	 */
	public List<Student> studentiDrugeGodine() {
		List<Student> student2 = studentDAO.getStudentiDrugeGodine();
		return student2;

	}

	/*
	 * Metoda za odvajanje liste studenata trece godine return List studenti trece
	 * godine
	 */
	public List<Student> studentiTreceGodine() {
		List<Student> student3 = studentDAO.getStudentiTreceGodine();
		return student3;

	}

	/*
	 * Metoda za odvajanje liste studenata cetvrte godine return List studenti trece
	 * godine
	 */
	public List<Student> studentiCetvrteGodine() {
		List<Student> student4 = studentDAO.getStudentiCetvrteGodine();
		return student4;

	}

	/*
	 * Metoda za odvajanje liste apsolvenata return List apsolventi
	 */
	public List<Student> studentiApsolventi() {
		List<Student> student5 = studentDAO.getStudentiApsolventi();
		return student5;
	}

}
