package lotto.validation;

import static lotto.constant.ErrorMessageConstants.DUPLICATE_VALUE_EXISTS;
import static lotto.constant.ErrorMessageConstants.OUT_NUMBER_RANGE;
import static lotto.constant.ErrorMessageConstants.VALUE_IS_NOT_NUMBER;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberValidation {

    public void validate(List<Integer> numbers) {
        // 범위 예외
        for (int input : numbers) {
            numberRange(input);
        }
        // 중복 예외
        duplicateValid(numbers);
    }

    public void numberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(OUT_NUMBER_RANGE);
        }
    }

    public void duplicateValid(List<Integer> numbers) {
        long afterSize = numbers.stream().distinct().count();
        if (numbers.size() != afterSize) {
            throw new IllegalArgumentException(DUPLICATE_VALUE_EXISTS);
        }
    }

    public void bonusNumberDuplicateValid(List<Integer> numbers, int bonus) {
        List<Integer> tempNumbers = new ArrayList<>(numbers);
        tempNumbers.add(bonus);
        duplicateValid(tempNumbers);
    }

    public void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALUE_IS_NOT_NUMBER);
        }
    }
}
