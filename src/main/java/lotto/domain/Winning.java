package lotto.domain;

import lotto.common.error.CustomException;
import lotto.common.error.ErrorMessage;
import java.util.List;

public class Winning {
    private static final int LOTTO_SIZE = 6;

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
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }

    private boolean isNonSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private boolean isDuplicateBonus(List<Integer> numbers, int bonus) {
        return numbers.contains(bonus);
    }
}
