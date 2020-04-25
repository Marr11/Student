package com.skolamaric;

import java.util.List;

import com.skolamaric.model.Student;
import com.skolamaric.servis.AdministriranjeStudenta;
import com.skolamaric.utils.KONSTANTE;
import com.skolamaric.utils.PrikaziUtils;

public class App {
	
	public static void main(String[] args) {
		AdministriranjeStudenta administriranje =  new AdministriranjeStudenta();

		List<Student> studenti = administriranje.generisanje();
		System.out.println("=================Spisak studenata======================================");
		System.out.println("Ukupan broj studenata: " + studenti.size());
		PrikaziUtils.IzlistajStudente(studenti);

		List<Student> student1 = AdministriranjeStudenta.studentiPrveGodine(studenti);
		System.out.println("=================Spisak studenata prve godine===========================");
		System.out.println("Ukupan broj studenata: " + student1.size());
		PrikaziUtils.IzlistajStudente(student1);

		List<Student> student2 = AdministriranjeStudenta.studentiDrugeGodine(studenti);
		System.out.println("=================Spisak studenata druge godine===========================");
		System.out.println("Ukupan broj studenata: " + student2.size());
		PrikaziUtils.IzlistajStudente(student2);

		List<Student> student3 = AdministriranjeStudenta.studentiTreceGodine(studenti);
		System.out.println("=================Spisak studenata trece godine===========================");
		System.out.println("Ukupan broj studenata: " + student3.size());
		PrikaziUtils.IzlistajStudente(student3);

		List<Student> student4 = AdministriranjeStudenta.studentiCetvrteGodine(studenti);
		System.out.println("=================Spisak studenata cetvrte godine===========================");
		System.out.println("Ukupan broj studenata: " + student4.size());
		PrikaziUtils.IzlistajStudente(student4);

		List<Student> student5 = AdministriranjeStudenta.studentiApsolventi(studenti);
		System.out.println("=================Spisak studenata apsolvenata===========================");
		System.out.println("Ukupan broj studenata: " + student5.size());
		PrikaziUtils.IzlistajStudente(student5);
		
	}

}
