package lotto;

import lotto.enums.LottoConfig;
import lotto.exception.LottoExceptionMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        int start = LottoConfig.LOTTO_START_NUM.getValue();
        int end = LottoConfig.LOTTO_END_NUM.getValue();
        int length = LottoConfig.LOTTO_NUM_LENGTH.getValue();

        if (numbers.size() != length) {
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUM_LENGTH_NOT_SATISFIED.getMessage());
        }

        if (numbers.stream().anyMatch(number -> (number < start) || (number > end))) {
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUM_OUT_OF_RANGE.getMessage());
        }

        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(LottoExceptionMessage.LOTTO_NUM_DUPLICATED.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return getNumbers().getLast();
    }

    @Override
    public String toString() {
        return getNumbers().toString();
    }
}
