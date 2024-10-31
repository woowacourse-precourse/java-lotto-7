package lotto.model;

import java.util.List;

public class BonusNumber {
    private final static String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final static String INVALID_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1 이상 45 이하로 입력해주세요.";

    private final int bonus;

    public BonusNumber(List<Integer> numbers, int bonus) {
        validateNumberRange(bonus);
        validateDuplicate(numbers, bonus);
        this.bonus = bonus;
    }

    private void validateDuplicate(List<Integer> numbers, int input) {
        if (numbers.contains(input)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateNumberRange(int input) {
        if (!(RandomNumber.MIN_NUMBER <= input && input <= RandomNumber.MAX_NUMBER)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public int get() {
        return bonus;
    }
}
