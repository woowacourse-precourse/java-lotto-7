package lotto.domain.lotto;

import static lotto.constant.Error.*;
import static lotto.constant.LottoConstant.*;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int countHits(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
            .filter(numbers::contains)
            .count();
    }

    public boolean hits(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
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