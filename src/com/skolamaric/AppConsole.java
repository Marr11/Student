package com.skolamaric;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.skolamaric.exceptions.dao.ResultNotFoundException;
import com.skolamaric.model.Student;
import com.skolamaric.servis.AdministriranjeStudenta;
import com.skolamaric.utils.PrikaziUtils;

public class AppConsole {
	/*
	 * Konzolna aplikacija Graphical user interface(GUI)
	 */
	static AdministriranjeStudenta administriranje = new AdministriranjeStudenta();

	public static void main(String[] args) throws ResultNotFoundException {
		Date date = new Date();
		System.out.println("Pocetak rada aplikacije: " + date);
		System.out.println("=====================================================");
		administriranje.generisanje();
		Scanner in = new Scanner(System.in);

		while (1 == 1) {
			System.out.println("-----------------GLAVNA PETLJA------------------");
			prikaziOpcije();
			String s = in.nextLine();
			switch (s) {
			case "0":
				Opcija0();
				break;
			case "1":
				Opcija1();
				break;
			case "2":
				Opcija2();
				break;
			case "3":
				Opcija3();
				break;
			case "4":
				Opcija4();
				break;
			case "5":
				Opcija5();
				break;

			}

			if ("kraj".equals(s)) {
				System.out.println("Uneli ste komandu za kraj.");
				System.out.println("Program je izvrsen. Hvala!!!");
				break;
			}

		}

	}

	private static void Opcija0() throws ResultNotFoundException {
		List<Student> studenti = administriranje.dajSveStudente();
		System.out.println("=================Spisak studenata======================================");
		System.out.println("Ukupan broj studenata: " + studenti.size());
		PrikaziUtils.IzlistajStudente(studenti);
	}

	private static void Opcija1() {
		List<Student> student1 = administriranje.studentiPrveGodine();
		System.out.println("=================Spisak studenata prve godine===========================");
		System.out.println("Ukupan broj studenata: " + student1.size());
		PrikaziUtils.IzlistajStudente(student1);
	}

	private static void Opcija2() {
		List<Student> student2 = administriranje.studentiDrugeGodine();
		System.out.println("=================Spisak studenata druge godine===========================");
		System.out.println("Ukupan broj studenata: " + student2.size());
		PrikaziUtils.IzlistajStudente(student2);
	}

	private static void Opcija3() {
		List<Student> student3 = administriranje.studentiTreceGodine();
		System.out.println("=================Spisak studenata trece godine===========================");
		System.out.println("Ukupan broj studenata: " + student3.size());
		PrikaziUtils.IzlistajStudente(student3);
	}

	private static void Opcija4() {
		List<Student> student4 = administriranje.studentiCetvrteGodine();
		System.out.println("=================Spisak studenata cetvrte godine===========================");
		System.out.println("Ukupan broj studenata: " + student4.size());
		PrikaziUtils.IzlistajStudente(student4);
	}

	private static void Opcija5() {
		List<Student> student5 = administriranje.studentiApsolventi();
		System.out.println("=================Spisak studenata  apsolvenata===========================");
		System.out.println("Ukupan broj studenata: " + student5.size());
		PrikaziUtils.IzlistajStudente(student5);
	}

	private static void prikaziOpcije() {
		System.out.println("opcija 0 - izlistaj sve studente");
		System.out.println("opcija 1 - izlistaj studente prve godine");
		System.out.println("opcija 2 - izlistaj studente druge godine");
		System.out.println("opcija 3 - izlistaj studente trece godine");
		System.out.println("opcija 4 - izlistaj studente cetvrte godine");
		System.out.println("opcija 5 - izlistaj studente apsolvente");
	}
}
