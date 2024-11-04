package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionMessage;

public class LottoMachine {
    private static final Integer MINIMUM_LOTTO_NUMBER = 1;
    private static final Integer MAXIMUM_LOTTO_NUMBER = 45;
    private static final Integer LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public LottoMachine(List<Integer> numbers, Integer bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = new ArrayList<>(numbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return new ArrayList<>(numbers);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> numbers, Integer bonusNumber) {
        validateNumbers(numbers);
        validateBonusNumber(numbers, bonusNumber);
    }

    private void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumber(number);
        }

        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER_LOTTO.getMessage());
        }
    }

    private void validateNumber(Integer number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        }
        validateNumber(bonusNumber);
    }
}
