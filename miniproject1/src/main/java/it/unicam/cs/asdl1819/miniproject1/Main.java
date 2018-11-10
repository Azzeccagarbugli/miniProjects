package it.unicam.cs.asdl1819.miniproject1;

import java.util.Scanner;

public class Main {
	public static void main (String [ ] args) {
		Scanner reader = new Scanner(System.in);  
		System.out.print("Inserisci un numero da fattorizzare: ");
		int n = reader.nextInt();
		reader.close();
		
		Factoriser f = new Factoriser();
		Multiset<Integer> m = f.getFactors(n);
		
		System.out.println("I fattori primi del numero " + n + " sono i seguenti: " + m);	
	}
}
