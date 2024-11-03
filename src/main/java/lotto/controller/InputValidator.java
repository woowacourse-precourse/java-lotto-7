package lotto.controller;

import java.math.BigInteger;
import java.util.List;

import static lotto.exception.ExceptionCode.*;

public class InputValidator {

    public static final String SPLITTER = ",";

    public static void validateBudgetInput(String budgetInput) {
        try {
            new BigInteger(budgetInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.message());
        }
    }

    public static void validateWinningNumbers(String winningNumbers) {
        List<String> tokens = List.of(winningNumbers.split(SPLITTER));
        try {
            for (String token : tokens) {
                new BigInteger(token);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.message());
        }
    }

    public static void validateNumberInput(String numberInput) {
        try {
            Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.message());
        }
    }

}
