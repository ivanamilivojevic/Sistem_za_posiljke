package posiljke;

import java.util.Scanner;

public class Pismo {
	
	private String posaljilac;
	private String primalac;
	private int postanski_br;
	private double tezina;
	private boolean prioritetna;
	

	public Pismo(String posaljilac, String primalac, int postanski_br, double tezina, boolean prioritetna) {
		this.posaljilac = posaljilac;
		this.primalac = primalac;
		this.postanski_br = postanski_br;
		this.tezina = tezina;
		this.prioritetna = prioritetna;
	}
	
	public double cena() {
		double suma = 0;
		if(tezina <= 20) {
			suma += 23;
		}else if (tezina <= 100) {
			suma += 35; 
		}else if (tezina <= 500) {
			suma += 81;
		}else {
			suma += 127;
		}
		if(prioritetna)
			suma += 46;
		return suma;
	}
	public String toString() {		
		return String.format("%s -> %s : %d, %.0fg %s => %.2fdin", posaljilac, primalac, postanski_br,tezina,prioritetna ? "prioritetna" : "",cena());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodošli u pametni sistem pošte!");
		System.out.println("-------------------------------------");
		System.out.println("Unesite pristigla pisma: ");
		
		Pismo[] niz = new Pismo[100];
		int duzina = 0;
		
		for(String unos=sc.next(); !unos.equals("kraj"); unos=sc.next()) {
			niz[duzina++] = new Pismo(unos + " " + sc.next(), sc.next() + " " + sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextBoolean());
		}
		System.out.println("Pisma uspešno učitana!");
		System.out.println("-------------------------------------");
				
		
		System.out.print("Unesite poštanski br. grada: ");
		for(int postanski_br =sc.nextInt(); postanski_br!=-1; postanski_br=sc.nextInt()) {
			for(int i=0;i<duzina;i++)
				if(niz[i].postanski_br == postanski_br)
					System.out.println(niz[i]);
			System.out.println("-------------------------------------");
			System.out.print("Unesite poštanski br. grada: ");
		}
			
	}

}
