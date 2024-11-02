package lotto.io;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.exception.ExceptionMessages;

public class InputValidator {

    private static final String DIGIT_REGEX = "^-?[0-9]*$";
    private static final String INPUT_DELIM = ",";

    public Money validateAmountOfMoney(String input) {
        validateWhiteSpace(input);
        validateNonDigitInput(input);
        validateOutOfRangeAmount(input);
        int amountOfMoney = Integer.parseInt(input);

        return new Money(amountOfMoney);
    }

    public Lotto validateWinningNumbers(String input) {
        validateWhiteSpace(input);
        validateEmptyElemFromInput(input);
        validateEndsWithComma(input);
        validateExistNotDigitElems(input);

        List<Integer> numbers = convertStringToList(input);
        return new Lotto(numbers);
    }

    public BonusNumber validateBonusNumber(String input) {
        validateWhiteSpace(input);
        validateNonDigitInput(input);

        int number = Integer.parseInt(input);
        return new BonusNumber(number);
    }

    private void validateWhiteSpace(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_WHITESPACE.getMessage());
        }
    }

    private void validateNonDigitInput(String input) {
        if (!input.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_DIGIT.getMessage());
        }
    }

    private void validateOutOfRangeAmount(String input) {
        long amount = Long.parseLong(input);
        if (amount > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ExceptionMessages.AMOUNT_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateEmptyElemFromInput(String input) {
        String[] splitInput = input.split(INPUT_DELIM);
        Arrays.stream(splitInput).forEach(elem -> {
            if (elem.isBlank()) {
                throw new IllegalArgumentException(ExceptionMessages.EMPTY_ELEM_EXIST.getMessage());
            }
        });
    }

    private void validateEndsWithComma(String input) {
        if (input.endsWith(INPUT_DELIM)) {
            throw new IllegalArgumentException(ExceptionMessages.ENDS_WITH_COMMA.getMessage());
        }
    }

    private void validateExistNotDigitElems(String input) {
        String[] elems = input.split(INPUT_DELIM);
        Arrays.stream(elems).forEach(this::validateNonDigitInput);
    }

    private List<Integer> convertStringToList(String input) {
        String[] numbers = input.split(INPUT_DELIM);
        return Arrays.stream(numbers)
                .map(number -> Integer.parseInt(number.strip()))
                .sorted(Comparator.naturalOrder())
                .toList();
    }
}
