package lotto.user;

import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.system.utils.constants.LottoConstants.LOTTO_NUMBER_UPPER_BOUND;
import static lotto.system.utils.constants.LottoErrorMessages.INVALID_NUMBER_DUPLICATE;
import static lotto.system.utils.constants.LottoErrorMessages.INVALID_NUMBER_RANGE;

import java.util.List;

public class Bonus { // 사용자 입력 보너스 검증 후 객체 생성

    private final int number;

    public Bonus(int number, List<Integer> numbers) {
        validate(number, numbers);
        this.number = number;
    }

    private void validate(int number, List<Integer> numbers) {
        validateNumberBound(number);
        validateDuplicate(number, numbers);
    }

    private void validateNumberBound(int number) {
        if (number < LOTTO_NUMBER_LOWER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage(
                    LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND));
        }
    }

    private void validateDuplicate(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_DUPLICATE.getMessage());
        }

    }

    public int getNumber() {
        return number;
    }
}
