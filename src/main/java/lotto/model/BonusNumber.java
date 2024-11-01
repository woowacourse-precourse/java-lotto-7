package lotto.model;

import java.util.List;
import lotto.util.ExceptionHelper;

import static lotto.model.Lotto.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static lotto.model.constant.Lotto.MAX_NUMBER;
import static lotto.model.constant.Lotto.MIN_NUMBER;

public class BonusNumber {
    public final static String INVALID_NUMBER_RANGE_ERROR_MESSAGE = "번호는 1 이상 45 이하로 입력해주세요.";

    private final int bonus;

    public BonusNumber(final List<Integer> numbers, final int bonus) {
        validateNumberRange(bonus);
        validateDuplicate(numbers, bonus);
        this.bonus = bonus;
    }

    private void validateDuplicate(final List<Integer> numbers, final int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ExceptionHelper.errorMessage(DUPLICATE_NUMBER_ERROR_MESSAGE));
        }
    }

    private void validateNumberRange(final int bonus) {
        if (!(MIN_NUMBER <= bonus && bonus <= MAX_NUMBER)) {
            throw new IllegalArgumentException(ExceptionHelper.errorMessage(INVALID_NUMBER_RANGE_ERROR_MESSAGE));
        }
    }

    public int get() {
        return bonus;
    }
}