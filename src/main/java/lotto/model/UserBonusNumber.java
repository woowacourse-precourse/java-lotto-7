package lotto.model;

import java.util.List;

public class UserBonusNumber {
    private final static String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";

    private final int bonus;

    public UserBonusNumber(List<Integer> numbers, int bonus) {
        this.bonus = bonus;
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    public int get() {
        return bonus;
    }
}
