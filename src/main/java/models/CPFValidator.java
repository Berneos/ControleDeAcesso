/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Daniel
 */

import java.util.InputMismatchException;

public class CPFValidator {

    // Valida CPF
    public static boolean isValid(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^\\d]", "");

        // Verifica se tem 11 dígitos
        if (cpf.length() != 11 || isRepeated(cpf)) {
            return false;
        }

        // Validação dos dígitos verificadores
        return validateDigits(cpf);
    }

    // Formata CPF
    public static String format(String cpf) {
        cpf = cpf.replaceAll("[^\\d]", ""); // Remove caracteres não numéricos
        if (cpf.length() != 11) {
            throw new InputMismatchException("CPF deve ter 11 dígitos.");
        }
        return String.format("%s.%s.%s-%s",
                cpf.substring(0, 3),
                cpf.substring(3, 6),
                cpf.substring(6, 9),
                cpf.substring(9, 11));
    }

    // Valida se o CPF é repetido (ex: 111.111.111-11)
    private static boolean isRepeated(String cpf) {
        return cpf.chars().allMatch(c -> c == cpf.charAt(0));
    }

    // Valida os dígitos verificadores do CPF
    private static boolean validateDigits(String cpf) {
        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Character.getNumericValue(cpf.charAt(i));
        }

        // Valida primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += digits[i] * (10 - i);
        }
        int firstCheck = 11 - (sum % 11);
        if (firstCheck >= 10) firstCheck = 0;
        if (firstCheck != digits[9]) return false;

        // Valida segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += digits[i] * (11 - i);
        }
        int secondCheck = 11 - (sum % 11);
        if (secondCheck >= 10) secondCheck = 0;
        return secondCheck == digits[10];
    }
}
