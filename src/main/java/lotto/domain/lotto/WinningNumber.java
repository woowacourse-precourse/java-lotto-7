package lotto.domain.lotto;

import static lotto.infrastructure.exception.ErrorCode.INVALID_LOTTO_DUPLICATED_BONUS_NUMBER;

import java.util.List;
import lotto.domain.lotto.vo.Number;

public class WinningNumber extends Lotto {

    private final Number bonusNumber;

    public WinningNumber(List<Integer> numbers, int number) {
        super(numbers);
        validate(numbers, number);
        this.bonusNumber = new Number(number);
    }

    private void validate(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(INVALID_LOTTO_DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}
