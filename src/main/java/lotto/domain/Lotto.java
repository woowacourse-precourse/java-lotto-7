package lotto.domain;

import static lotto.constant.Error.DUPLICATED_LOTTO_NUMBERS;
import static lotto.constant.Error.RANGE_LOTTO_NUMBER;
import static lotto.constant.Error.SIZE_LOTTO_NUMBERS;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;
import static lotto.constant.LottoConstant.SIZE_NUMBERS;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE_NUMBERS) {
            throw new IllegalArgumentException(SIZE_LOTTO_NUMBERS);
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS);
        }

        if (numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw new IllegalArgumentException(RANGE_LOTTO_NUMBER);
        }
    }
}