package sample;

import java.util.LinkedHashSet;
import java.util.List;

public class InserirValores {

   public static String vet4[]= new String[17];
	public static String vet1[]= new String[17];
	public static String vet2[]= new String[17];
	public static String vet3[]= new String[17];
	
	public static void PrencherVariaveis(int cont) {
		//calculando o numero de linhas
		int linhas=(int) Math.pow(2,cont);
		//Verificando para prencher a primeira variavel que é metade V F
		int var=linhas/2;
		//variaveis que serão usadas para auxiliar a preencher a 2 variavel
		int part_lin=0,part_lin2=0;
		
		System.out.println(linhas);
		for(int j=1;j<=cont;j++) {
			// contas para tentar acerta o lugar de prencher o segundo vetor que é o que os V F se alternam
			
			if(j==2) {
			part_lin=var/2;	
			part_lin2=var+(var/2);
			}
			
			
			
			// prenchendo os vetores
			for(int i=1;i<=linhas;i++) {	
				// Preenchendo o primeiro que metade e V e metade F
				if(j==1 && i<=var) {
					vet1[i]="V";
					
				}
				if(j==1 && i>var) {
					vet1[i]="F";
					
				}
				// Preenchendo segundo vetor
				if(j==2 && i<=part_lin) {
					vet2[i]="V";
				}
				if(j==2 && i>part_lin && i<=var) {
					vet2[i]="F";
				}
				
				if(j==2 && i>var && i<=part_lin2) {
					vet2[i]="V";
				}
				if(j==2 && i>part_lin2) {
					vet2[i]="F";
				}
				//Preenchendo a terceira variavel
				if(j==3 && cont==3) {
					if((i>0 && i<3)||(i>4 && i<7)) {
						vet3[i]="V";
					}
					if((i>2 && i<5)||(i>6 )) {
						vet3[i]="F";
					}
				}
				if(j==3 && cont==4) {
					if((i>0 && i<3)||(i>4 && i<7)||(i>8 && i<11)||(i>12 && i<15)) {
						vet3[i]="V";
					}
					if((i>2 && i<5)||(i>6 && i<9)||(i>10 && i<13)||(i>14 && i<17)) {
						vet3[i]="F";
					}
				}
				//Preenchendo o quarto vetor
				if(j==4 &&(i%2==0)) {
					vet4[i]="F";
				}else vet4[i]="V";
				
			
		}
			
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		// essa variavel cont é a varivel que você vai decidir quantos argumentos vai usar MAX=4
		int cont=4;
		
		int linhas=(int) Math.pow(2,cont)+1;
		
		PrencherVariaveis(cont);
		if(cont>=1) {
		System.out.println("Valores da primeira variavel");
		for(int i=1;i<linhas;i++) 
		System.out.println(vet1[i]);
		}
		if(cont>=2) {
		System.out.println("Valores da segunda variavel");
		for(int i=1;i<linhas;i++)
		System.out.println(vet2[i]);
		}if(cont>=3) {
		System.out.println("Valores da terceira variavel");
		for(int i=1;i<linhas;i++)
			System.out.println(vet3[i]);
		}
		if(cont>=4) {
			System.out.println("Valores da qaurta variavel");
			for(int i=1;i<linhas;i++)
				System.out.println(vet4[i]);
			}
	}

}
