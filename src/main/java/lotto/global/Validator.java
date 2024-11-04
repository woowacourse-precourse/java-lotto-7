package lotto.global;

import static lotto.enums.Symbol.COMMA;
import static lotto.exception.ErrorCode.*;
import static lotto.exception.ErrorCode.DUPLICATE_WINNING_NUMBER;
import static lotto.exception.ErrorCode.INVALID_NUMBER_RANGE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.model.Lotto;

public class Validator {
    private static final Validator instance = new Validator();

    private Validator() {}

    public static Validator getInstance() {
        return instance;
    }

    public void validatePurchaseAmount(String purchaseAmount) {
        validateNotEmpty(purchaseAmount);
        validateInteger(purchaseAmount);
        validatePositiveInteger(purchaseAmount);
        validateMultipleOfThousand(purchaseAmount);
    }

    public void validateWinningNumbers(String winningNumbers) {
        validateNotEmpty(winningNumbers);
        List<Integer> parsedWinningNumbers = parseWinningNumbers(winningNumbers);

        validateUniqueNumbers(parsedWinningNumbers); // 중복 검사 메소드 호출
        new Lotto(parsedWinningNumbers);
    }

    private List<Integer> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(COMMA.getValue()))
                .map(String::trim)
                .map(this::parseNumber)
                .toList();
    }

    private int parseNumber(String number) {
        try {
            int parsedNumber = Integer.parseInt(number);
            validateNumberInRange(parsedNumber);
            return parsedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT.getMessage());
        }
    }

    private void validateNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private void validateNotEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT.getMessage());
        }
    }

    private void validatePositiveInteger(String input) {
        int intInput = Integer.parseInt(input);
        if(intInput <= 0){
            throw new IllegalArgumentException(NOT_POSITIVE_INPUT.getMessage());
        }
    }

    private void validateMultipleOfThousand(String purchaseAmount) {
        int parsedAmount = Integer.parseInt(purchaseAmount);
        if (parsedAmount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

}
