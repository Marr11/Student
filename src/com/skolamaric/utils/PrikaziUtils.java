package com.skolamaric.utils;

import java.util.List;

import com.skolamaric.model.Student;

public class PrikaziUtils {
	public static void IzlistajStudente(List<Student> studenti){
		studenti.forEach(PrikaziUtils::printStudent);
			
		}	
		
	public static void printStudent(Student student) {
		System.out.println(student.toString());
	}
}
