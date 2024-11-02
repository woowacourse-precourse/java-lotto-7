package lotto.domain;

import static lotto.constant.ErrorMessage.INVALID_PICK_COUNT;
import static lotto.constant.LottoSystemConstant.LOTTO_PICK_COUNT;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_PICK_COUNT) {
            throw new IllegalArgumentException(INVALID_PICK_COUNT);
        }
    }

    // TODO: 추가 기능 구현
}
