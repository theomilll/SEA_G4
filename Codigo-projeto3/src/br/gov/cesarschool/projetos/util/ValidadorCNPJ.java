package br.gov.cesarschool.projetos.util;

public class ValidadorCNPJ {
    
    public static boolean validarCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            return false;
        }

        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
            cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
            cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
            cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
            cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
            return false;
        }

        int[] digitos = new int[14];
        for (int i = 0; i < 14; i++) {
            digitos[i] = Character.getNumericValue(cnpj.charAt(i));
        }

        int soma1 = digitos[0] * 5 + digitos[1] * 4 + digitos[2] * 3 +
                    digitos[3] * 2 + digitos[4] * 9 + digitos[5] * 8 +
                    digitos[6] * 7 + digitos[7] * 6 + digitos[8] * 5 +
                    digitos[9] * 4 + digitos[10] * 3 + digitos[11] * 2;

        int digito1 = 11 - (soma1 % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }

        int soma2 = digitos[0] * 6 + digitos[1] * 5 + digitos[2] * 4 +
                    digitos[3] * 3 + digitos[4] * 2 + digitos[5] * 9 +
                    digitos[6] * 8 + digitos[7] * 7 + digitos[8] * 6 +
                    digitos[9] * 5 + digitos[10] * 4 + digitos[11] * 3 +
                    digito1 * 2;

        int digito2 = 11 - (soma2 % 11);
        if (digito2 >= 10) {
            digito2 = 0;
        }

        return digitos[12] == digito1 && digitos[13] == digito2;
    }
}
