package lotto.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ExceptionsMessageConstants;

public class InputViewException {

    public void validateInputMoney(String inputMoney) {
        validateMoneyFormat(inputMoney);
        validateIfMoneyPositive(inputMoney);
        validateIfMoneyMultipleOfThousand(inputMoney);
        validateIfMoneyStartsWithZero(inputMoney);
        validateIfInputContainsWhitespace(inputMoney);
    }

    private void validateMoneyFormat(String inputMoney) {
        try {
            Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.INPUT_MUST_BE_NUMERIC);
        }
    }

    private void validateIfMoneyPositive(String inputMoney) {
        int money = Integer.parseInt(inputMoney);
        if (money <= 0) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.INPUT_NUMBER_MUST_BE_POSITIVE);
        }
    }

    private void validateIfMoneyMultipleOfThousand(String inputMoney) {
        if (Integer.parseInt(inputMoney) % 1000 != 0) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.MONEY_MUST_BE_A_MULTIPLE_OF_THOUSAND);
        }
    }

    private void validateIfMoneyStartsWithZero(String inputMoney) {
        if (!inputMoney.equals(String.valueOf(Integer.parseInt(inputMoney)))) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.INPUT_NUMBER_CANNOT_START_WITH_ZERO);
        }
    }

    private void validateIfInputContainsWhitespace(String inputMoney) {
        if (inputMoney.contains(" ")) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.INPUT_CONTAINS_WHITE_SPACE);
        }
    }

    public void validateInputNumbers(String inputNumbers) {
        validateIfInputContainsNullOrEmpty(inputNumbers);
        validateIfInputContainsWhitespace(inputNumbers);
        validateIfInputContainsOtherThanNumbersAndComma(inputNumbers);
        validateNumbersCount(inputNumbers);
        validateNumbersRange(inputNumbers);
        validateIfNumbersDuplicated(inputNumbers);
    }

    private void validateIfInputContainsNullOrEmpty(String inputNumbers) {
        if (inputNumbers == null || inputNumbers.isEmpty()) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.INPUT_CANNOT_BE_EMPTY_OR_NULL);
        }
    }

    private void validateIfInputContainsOtherThanNumbersAndComma(String inputNumbers) {
        if (!inputNumbers.matches("[0-9,]+")) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.INPUT_CONTAINS_NUMBER_AND_COMMA_ONLY);
        }
    }

    private void validateNumbersCount(String inputNumbers) {
        String[] numbers = inputNumbers.split(",");
        if (numbers.length > 6) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.INPUT_NUMBERS_COUNT_MUST_BE_SIX);
        }
    }

    private void validateNumbersRange(String inputNumbers) {
        List<String> numbers = Arrays.stream(inputNumbers.split(",")).toList();
        for (String number : numbers) {
            if (!number.equals(String.valueOf(Integer.parseInt(number))) || Integer.parseInt(number) <= 0
                    || Integer.parseInt(number) > 45) {
                throw new IllegalArgumentException(ExceptionsMessageConstants.ERROR
                        + ExceptionsMessageConstants.INPUT_NUMBERS_MUST_BE_IN_ALLOWED_RANGE);
            }
        }
    }

    private void validateIfNumbersDuplicated(String inputNumbers) {
        List<String> numbers = Arrays.stream(inputNumbers.split(",")).toList();
        Set<String> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(
                    ExceptionsMessageConstants.ERROR + ExceptionsMessageConstants.INPUT_NUMBERS_CANNOT_BE_DUPLICATED);
        }
    }

    public void validateInputBonusNumber(String inputBonusNumber) {
        validateIfInputContainsWhitespace(inputBonusNumber);
        validateIfInputContainsNullOrEmpty(inputBonusNumber);
    }


}
