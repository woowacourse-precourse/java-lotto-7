package domain;

import static exception.ErrorMessage.LOTTO_NUMBER_CONTAINS_BONUS_NUMBER;

import java.util.List;

public class Winning {

    private final List<Integer> numbers;

    private final int bonusNumber;

    public Winning(List<Integer> numbers, int bonusNumber) {
        verifyLottoContainsBonusNumber(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void verifyLottoContainsBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_CONTAINS_BONUS_NUMBER.getMessage());
        }
    }

}
