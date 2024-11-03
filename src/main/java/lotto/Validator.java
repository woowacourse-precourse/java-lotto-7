package lotto;

import java.util.ArrayList;

public class Validator {
    public static void validateAmount(String input) {
        isOnlyDigits(input);
        int amount = Integer.parseInt(input);
        isAmountInRange(amount);
        isValidAmountUnit(amount);
    }

    public static void validateUserPickNumbers(String input) {
        isOnlyDigitsAndCommas(input);
        ArrayList<Integer> numbers = Parser.parseNumbersByComma(input);
        isValidNumbersCount(numbers);
        isNumbersInRange(numbers);
        isNumbersUnique(numbers);
    }

    public static void validateUserPickBonus(String input, ArrayList<Integer> numbers) {
        isOnlyDigits(input);
        int bonus = Integer.parseInt(input);
        isBonusInRange(bonus);
        isBonusUnique(bonus, numbers);
    }

    private static void isOnlyDigits(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c) == false) {
                ErrorHandler.printAndThrow(Constants.INPUT_ERROR_FORM);
            }
        }
    }

    private static void isAmountInRange(int amount) {
        if (amount < Constants.AMOUNT_MIN || Constants.AMOUNT_MAX < amount) {
            ErrorHandler.printAndThrow(Constants.INPUT_ERROR_FORM);
        }
    }

    private static void isValidAmountUnit(int amount) {
        if ((amount % Constants.AMOUNT_UNIT) != 0) {
            ErrorHandler.printAndThrow(Constants.INPUT_ERROR_FORM);
        }
    }

    private static void isOnlyDigitsAndCommas(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c) == false && c != ',') {
                ErrorHandler.printAndThrow(Constants.INPUT_ERROR_FORM);
            }
        }
    }

    private static void isValidNumbersCount(ArrayList<Integer> numbers) {
        if (numbers.size() != Constants.NUMBER_COUNT) {
            ErrorHandler.printAndThrow(Constants.INPUT_ERROR_FORM);
        }
    }

    private static void isNumbersInRange(ArrayList<Integer> numbers) {
        for (int i : numbers) {
            if (i < Constants.NUMBER_MIN || Constants.NUMBER_MAX < i) {
                ErrorHandler.printAndThrow(Constants.INPUT_ERROR_FORM);
            }
        }
    }

    private static void isNumbersUnique(ArrayList<Integer> numbers) {
        boolean[] checkedNumbers = new boolean[46];
        for (int i : numbers) {
            if (checkedNumbers[i] == true) {
                ErrorHandler.printAndThrow(Constants.INPUT_ERROR_FORM);
            }
            checkedNumbers[i] = true;
        }
    }

    private static void isBonusInRange(int bonus) {
        if (bonus < Constants.NUMBER_MIN || Constants.NUMBER_MAX < bonus) {
            ErrorHandler.printAndThrow(Constants.INPUT_ERROR_FORM);
        }
    }

    private static void isBonusUnique(int bonus, ArrayList<Integer> numbers) {
        for (int number : numbers) {
            if (number == bonus) {
                ErrorHandler.printAndThrow(Constants.INPUT_ERROR_FORM);
            }
        }
    }
}