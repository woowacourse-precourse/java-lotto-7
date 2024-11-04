package lotto.validator.entity;

import lotto.enums.ExceptionMessage;
import lotto.validator.Validator;

import java.util.HashSet;
import java.util.List;

// 로또 번호 검증 클래스
public class LottoValidator implements Validator {
    private final List<Integer> numbers;

    public LottoValidator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void validate() {
        isDuplicated();
        isValidCount();
        isValidNumbers();
    }

    private void isDuplicated() {
        if (numbers.size() > new HashSet<>(numbers).size()) {
            printErrorMessageAndThrowError(ExceptionMessage.LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

    private void isValidCount() {
        if (numbers.size() != 6) {
            printErrorMessageAndThrowError(ExceptionMessage.LOTTO_NUMBER_NOT_VALID_COUNT.getMessage());
        }
    }

    private void isValidNumbers() {
        for (int number : numbers) {
            isInRange(number);
        }
    }

    private void isInRange(int number) {
        if (number < 1 || number > 45) {
            printErrorMessageAndThrowError(ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
