package lotto.model;

import java.util.List;

import static lotto.constant.ErrorMessage.*;
import static lotto.model.StringParser.*;

public class Validation {

    public int validateInteger(String rawNumber) {
        try {
            return Integer.parseInt(rawNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + " " + INTEGER_ERROR.getMessage());
        }
    }

    public boolean isPositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + " " + NEGATIVE_ERROR.getMessage());
        }
        return true;
    }

    public int validateAmount(int amount) {
        if ((amount % UNIT_AMOUNT) == 0) {
            return amount / UNIT_AMOUNT;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + " " + THOUSANDS_ERROR.getMessage());
    }

    public boolean validateRange(int number) {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER) {
            return true;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + " " + RANGE_ERROR.getMessage());
    }

    public void validateSize(List<Integer> myNumbers) {
        if (myNumbers.size() > NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + " " + NUMBER_COUNT_ERROR.getMessage());
        }
    }

    public void isUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + " " + REPEAT_ERROR.getMessage());
        }
    }

    public void isUnique(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + " " + REPEAT_ERROR.getMessage());
        }
    }
}
