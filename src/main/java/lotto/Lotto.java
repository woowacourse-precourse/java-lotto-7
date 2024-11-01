package lotto;

import java.util.List;

import static lotto.common.constant.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SHOULD_BE_SIX.getErrorMessage());
        }
    }

    // TODO: 추가 기능 구현
}
