package lotto.model;

import static lotto.constant.Constants.ERROR_PREFIX;
import static lotto.constant.Constants.LOTTO_NUMBER_LENGTH;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_PREFIX + " 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
