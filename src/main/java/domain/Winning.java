package domain;

import static exception.ErrorMessage.LOTTO_NUMBER_CONTAINS_BONUS_NUMBER;
import static utils.NumberValidation.*;

import java.util.List;

public class Winning {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public Winning(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
        verifyLottoContainsBonusNumber(numbers, bonusNumber);
    }

    private void verifyLottoContainsBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_CONTAINS_BONUS_NUMBER.getMessage());
        }
    }

}
