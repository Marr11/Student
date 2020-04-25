package com.skolamaric.servis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.skolamaric.dao.StudentInMemoryDAOImpl;
import com.skolamaric.model.Student;
import com.skolamaric.utils.KONSTANTE;

public class AdministriranjeStudenta {
	private static final HashMap<String, Student> upisaniStudenti = new HashMap<String, Student>();
	
	public List<Student> generisanje() {
		List<Student> studenti = new ArrayList<Student>();
		for (int i = 0; i < 100; i++) {
			Student student = new Student();
			student.setIme(KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo());
			student.setPrezime(KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo() + KONSTANTE.slucajnoSlovo());
			student.setGodinaFakulteta(randomBrojGodine());
			student.setBrojIndeksa(randomBrojIndeksa());
			student.setBrojPolozenihIspita(randomBrojPolozenihIspita());
			studenti.add(student);
			
		}

		return studenti;
	}

	private int randomBrojGodine() {
		// random broj za godinu fakulteta, ali od 1-5
		int broj;
		broj = (int) (Math.random() * ((KONSTANTE.MAX_BROJ_GODINE_STUDIJA - KONSTANTE.MIN_BROJ_GODINE_STUDIJA) + 1))
				+ KONSTANTE.MIN_BROJ_GODINE_STUDIJA;
		
		return broj;
	}

	private int randomBrojPolozenihIspita() {
		// random funkcija za broj, broj polozenih ispita - izmedju 1-20
		int broj;
		broj = (int) (Math.random() * ((KONSTANTE.MAX_BROJ_POLOZENIH_ISPITA - KONSTANTE.MIN_BROJ_POLOZENIH_ISPITA) + 1))
				+ KONSTANTE.MIN_BROJ_POLOZENIH_ISPITA;

		return broj;
	}

	private String randomBrojIndeksa() {
				
		int broj = (int) (Math.random() * ((KONSTANTE.MAX_BROJ_ZA_INDEKS - KONSTANTE.MIN_BROJ_ZA_INDEKS) + 1))
				+ KONSTANTE.MIN_BROJ_ZA_INDEKS;		
		String randomBrojIndeksa = KONSTANTE.slucajnoSlovo() + broj;
		if(upisaniStudenti.containsKey(randomBrojIndeksa)) {
			System.out.println("DUPLIKAT" + randomBrojIndeksa);
			return randomBrojIndeksa();
		}
		upisaniStudenti.put(randomBrojIndeksa, null);
		return randomBrojIndeksa;
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
		List<Student> student3 = studenti.stream().filter(s -> s.getGodinaFakulteta() == 3 )
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
