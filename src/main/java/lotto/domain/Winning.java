package lotto.domain;

import lotto.common.Constant;
import lotto.common.error.CustomException;
import lotto.common.error.ErrorMessage;
import java.util.List;

public class Winning {
    private final List<Integer> numbers;
    private final int bonus;

    public Winning(List<Integer> numbers, int bonus) {
        validate(numbers, bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validate(List<Integer> numbers, int bonus) {
        if (isNonSize(numbers)) {
            throw new CustomException(ErrorMessage.LOTTO_NUMBERS_SIZE_ERROR_MESSAGE.toString());
        }

        if (isDuplicateBonus(numbers, bonus)) {
            throw new CustomException(ErrorMessage.BONUS_DUPLICATE_ERROR_MESSAGE.toString());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonus() {
        return this.bonus;
    }

    private boolean isNonSize(List<Integer> numbers) {
        return numbers.size() != Constant.LOTTO_SIZE;
    }

    private boolean isDuplicateBonus(List<Integer> numbers, int bonus) {
        return numbers.contains(bonus);
    }
}
