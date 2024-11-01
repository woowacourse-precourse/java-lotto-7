package lotto.Model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public void purchaseValidator(int input) {
        if (input < 1000 || input % 1000 != 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());
        }

    }

    public void bonusNumberValidator(int input) {
        validateRange(input);
    }

    public void winningNumberValidator(String[] setNumber) {
        validateNumberCount(setNumber);
        validateNoDuplicates(setNumber);
        Arrays.stream(setNumber).forEach(number->
                validateRange(Integer.parseInt(number)));
    }


    private void validateNumberCount(String[] setNumber) {
        if (setNumber.length != 6) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNoDuplicates(String[] numbers) {
        Set<String> uniqueNumbers = new HashSet<>(List.of(numbers));
        if (uniqueNumbers.size() != numbers.length) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
        }
    }
}