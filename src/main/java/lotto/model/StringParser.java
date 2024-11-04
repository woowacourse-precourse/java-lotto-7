package lotto.model;

import java.util.Arrays;
import java.util.List;

import static lotto.constant.ErrorMessage.*;

public class StringParser {
    private static final int UNIT_AMOUNT = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    public Integer findLottoCount(String rawAmount) {
        int amount = validateInteger(rawAmount);
        isPositive(amount);
        return validateAmount(amount);
    }

    public List<Integer> findMyNumbers(String rawNumbers) {
        List<String> splitNumbers = Arrays.stream(rawNumbers.split(","))
            .map(String::trim)
            .toList();

        List<Integer> myNumbers = validateMyNumbers(splitNumbers);

        return myNumbers;
    }

    public Integer findBonusNumber(List<Integer> myNumbers, String rawBonusNumber) {
        Integer bonusNumber = validateInteger(rawBonusNumber);
        isPositive(bonusNumber);
        validateRange(bonusNumber);
        isUnique(myNumbers, bonusNumber);
        return bonusNumber;
    }

    private List<Integer> validateMyNumbers(List<String> splitNumbers) {
        List<Integer> myNumbers = splitNumbers.stream().map(this::validateInteger)
            .filter(this::isPositive)
            .filter(this::validateRange)
            .toList();

        isUnique(myNumbers);
        validateSize(myNumbers);

        return myNumbers;
    }

    private int validateInteger(String rawNumber) {
        try {
            return Integer.parseInt(rawNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_ERROR.getMessage());
        }
    }

    private boolean isPositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(NEGATIVE_ERROR.getMessage());
        }
        return true;
    }

    private int validateAmount(int amount) {
        if ((amount % UNIT_AMOUNT) == 0) {
            return amount / UNIT_AMOUNT;
        }
        throw new IllegalArgumentException(THOUSANDS_ERROR.getMessage());
    }

    private boolean validateRange(int number) {
        if (number >= MIN_NUMBER && number <= MAX_NUMBER) {
            return true;
        }
        throw new IllegalArgumentException(RANGE_ERROR.getMessage());
    }

    private void validateSize(List<Integer> myNumbers) {
        if (myNumbers.size() > NUMBER_COUNT) {
            throw new IllegalArgumentException(NUMBER_COUNT_ERROR.getMessage());
        }
    }

    private void isUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBER_COUNT) {
            throw new IllegalArgumentException(REPEAT_ERROR.getMessage());
        }
    }

    private void isUnique(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(REPEAT_ERROR.getMessage());
        }
    }


}
