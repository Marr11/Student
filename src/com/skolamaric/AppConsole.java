package com.skolamaric;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.skolamaric.model.Student;
import com.skolamaric.servis.AdministriranjeStudenta;
import com.skolamaric.utils.PrikaziUtils;

public class AppConsole {
	/*
	 * Konzolna aplikacija Graphical user interface(GUI)
	 */
	static AdministriranjeStudenta administriranje = new AdministriranjeStudenta();

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("Pocetak rada aplikacije: " + date);
		System.out.println("=====================================================");
		List<Student> studenti = administriranje.generisanje();
		System.out.println("=================Spisak studenata========================================================");
		System.out.println("Ukupan broj studenata: " + studenti.size());
		//PrikaziUtils.IzlistajStudente(studenti);
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
				Opcija1(studenti);
				break;
			case "2":
				Opcija2(studenti);
				break;
			case "3":
				Opcija3(studenti);
				break;
			case "4":
				Opcija4(studenti);
				break;
			case "5":
				Opcija5(studenti);
				break;

			}

			if ("kraj".equals(s)) {
				System.out.println("Uneli ste komandu za kraj.");
				System.out.println("Program je izvrsen. Hvala!!!");
				break;
			}

		}

	}

	private static void Opcija0() {
		List<Student> studenti = administriranje.generisanje();
		System.out.println("=================Spisak studenata======================================");
		System.out.println("Ukupan broj studenata: " + studenti.size());
		PrikaziUtils.IzlistajStudente(studenti);
	}

	private static void Opcija1(List<Student> studenti) {
		List<Student> student1 = AdministriranjeStudenta.studentiPrveGodine(studenti);
		System.out.println("=================Spisak studenata prve godine===========================");
		System.out.println("Ukupan broj studenata: " + student1.size());
		PrikaziUtils.IzlistajStudente(student1);
	}

	private static void Opcija2(List<Student> studenti) {
		List<Student> student2 = AdministriranjeStudenta.studentiDrugeGodine(studenti);
		System.out.println("=================Spisak studenata druge godine===========================");
		System.out.println("Ukupan broj studenata: " + student2.size());
		PrikaziUtils.IzlistajStudente(student2);
	}

	private static void Opcija3(List<Student> studenti) {
		List<Student> student3 = AdministriranjeStudenta.studentiTreceGodine(studenti);
		System.out.println("=================Spisak studenata trece godine===========================");
		System.out.println("Ukupan broj studenata: " + student3.size());
		PrikaziUtils.IzlistajStudente(student3);
	}

	private static void Opcija4(List<Student> studenti) {
		List<Student> student4 = AdministriranjeStudenta.studentiCetvrteGodine(studenti);
		System.out.println("=================Spisak studenata cetvrte godine===========================");
		System.out.println("Ukupan broj studenata: " + student4.size());
		PrikaziUtils.IzlistajStudente(student4);
	}

	private static void Opcija5(List<Student> studenti) {
		List<Student> student5 = AdministriranjeStudenta.studentiApsolventi(studenti);
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
