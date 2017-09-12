package br.com.congressoti.demo;

public class Demo {

	public static void main(String[] args) {
		//comparação bit a bit
		/*1010 = 10
		  1001 = 9
		  
		  1010
		  1001
		  1000 = 9 //pega o que é igual entre os dois numeros 
		*/
		int x = 10 & 9;
		//System.out.println(x);
		
		
		/*
		 Deslocamento de bits a esquerda
		 
		 0010 = 2     base decimal
		 
		 0010 << 2 = 1000    
		 */	
		int y = 2 << 2;
		System.out.println(y);
	}
}
