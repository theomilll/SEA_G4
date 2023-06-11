package br.gov.cesarschool.projetos.util;
import java.io.Serializable;

@SuppressWarnings("serial")
public class ValidadorCPF implements Serializable{
	
	private ValidadorCPF() {
		
	}
	
	public static boolean ehCpfValido(String cpf) {
		if (cpf == null || cpf.length() != 11) {
			return false;
		}
		
		 for (int i = 0; i < cpf.length(); i++) {
		        if (cpf.charAt(i) < '0' || cpf.charAt(i) > '9') {
		            return false;
		        }
		}
		
		int soma = 0 ; 
		int primeiroDigitoVerificador;
		int segundoDigitoVerificador;
		
		for(int i = 1; i < 10;i++) {
			soma += Character.getNumericValue(cpf.charAt(i - 1)) * (i); 
		}
		
		int resto1 = soma % 11 ;
		if(resto1 == 10) {
			primeiroDigitoVerificador = 0;
		}
		
		else {
			primeiroDigitoVerificador = resto1;
		}
		
		soma = 0;
		for(int i = 1; i < 10;i++) {
			soma += Character.getNumericValue(cpf.charAt(i - 1)) * (10 - i); 
		} 

		
		int resto2 = soma % 11 ;
		if(resto2 == 10) {
			segundoDigitoVerificador = 0;
		}
		
		else {
			segundoDigitoVerificador = resto2;
		}
		
	    if (Character.getNumericValue(cpf.charAt(9)) != primeiroDigitoVerificador && Character.getNumericValue(cpf.charAt(10)) != segundoDigitoVerificador) {
	    	return false;
	    }
	    
		return true;
	}
}

