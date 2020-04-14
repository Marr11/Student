package com.skolamaric;

import java.util.List;

import com.skolamaric.model.Student;
import com.skolamaric.servis.AdministriranjeStudenta;
import com.skolamaric.utils.KONSTANTE;
import com.skolamaric.utils.PrikaziUtils;

public class App {
	public static void main(String[] args) {
		
		AdministriranjeStudenta administracija = new AdministriranjeStudenta();
		List<Student> studenti = administracija.generisanje();
		System.out.println("=================Spisak studenata======================================");
		System.out.println("Ukupan broj studenata: " + studenti.size());
		PrikaziUtils.IzlistajStudente(studenti);
			
			
		
		List <Student> student1 = administracija.studentiPrveGodine(studenti);
		System.out.println("=================Spisak studenata prve godine===========================");
		System.out.println("Ukupan broj studenata: " + student1.size());
		PrikaziUtils.IzlistajStudente(student1);
				
		
		//skrati ove dve metode - saznaj kako da napravis u tome foreach petlju i stavis sve u app
		
		List <Student> student2 = administracija.studentiDrugeGodine(studenti);
		System.out.println("=================Spisak studenata druge godine===========================");
		System.out.println("Ukupan broj studenata: " + student2.size());
		PrikaziUtils.IzlistajStudente(student2);
		
		
		
		List <Student> student3 = administracija.studentiTreceGodine(studenti);
		System.out.println("=================Spisak studenata trece godine===========================");
		System.out.println("Ukupan broj studenata: " + student3.size());
		PrikaziUtils.IzlistajStudente(student3);
		
		
		List <Student> student4 = administracija.studentiCetvrteGodine(studenti);
		System.out.println("=================Spisak studenata cetvrte godine===========================");
		System.out.println("Ukupan broj studenata: " + student4.size());
		PrikaziUtils.IzlistajStudente(student4);
		
		
		
		List <Student> student5 = administracija.studentiApsolventi(studenti);
		System.out.println("=================Spisak studenata apsolvenata===========================");
		System.out.println("Ukupan broj studenata: " + student5.size());
		PrikaziUtils.IzlistajStudente(student5);
	}
		
}
