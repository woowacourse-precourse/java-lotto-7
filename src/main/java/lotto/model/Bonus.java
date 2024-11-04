package lotto.model;

import java.util.List;

import static lotto.constant.Constants.LOTTO_END;
import static lotto.constant.Constants.LOTTO_START;

public class Bonus {
    private final int number;

    public Bonus(int number, List<Integer> numbers) {
        validate(number, numbers);
        this.number = number;
    }

    private void validate(int number, List<Integer> numbers) {
        validateRange(number);
        validateDuplicateNumber(number, numbers);
    }

    private void validateRange(int number) {
        if (number < LOTTO_START || number > LOTTO_END) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateNumber(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int getNumber() {
        return this.number;
    }
}
