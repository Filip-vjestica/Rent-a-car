package controller;

import java.util.Scanner;

//interfejs koji inicializuje scanner na svim drugom klasama 
public interface KorisnickiInput {
	Scanner input = new Scanner(System.in);
}
