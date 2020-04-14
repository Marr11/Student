package com.skolamaric.utils;

public class KONSTANTE {
	public static final int MIN_BROJ_GODINE_STUDIJA = 1;
	public static final int MAX_BROJ_GODINE_STUDIJA = 5;
	public static final int MIN_BROJ_POLOZENIH_ISPITA = 0;
	public static final int MAX_BROJ_POLOZENIH_ISPITA = 35;
	public static final int MIN_BROJ_ZA_INDEKS = 1;
	public static final int MAX_BROJ_ZA_INDEKS = 999;

	private static final int SLOVO_A = 65;
	private static final int SLOVO_Z = 90;

	public static String slucajnoSlovo() {
		char c = (char) slucajanBrojUintervalu(SLOVO_A, SLOVO_Z);
		return String.valueOf(c);
	}

	public static int slucajanBrojUintervalu(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}
}
