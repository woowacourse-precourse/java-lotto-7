package lotto.domain;

import java.util.List;

import static lotto.LottoConstants.LOTTO_SIZE;
import static lotto.message.ErrorMessage.LOTTO_SIZE_ERROR;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
