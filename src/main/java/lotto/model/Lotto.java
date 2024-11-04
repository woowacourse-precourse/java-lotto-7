package lotto.model;

import lotto.constant.ErrorMessage;

import java.util.List;

import static lotto.constant.LottoConfig.LOTTO_COUNT;
import static lotto.constant.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.MIN_LOTTO_NUMBER;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoCount(numbers);
        validateDuplicate(numbers);
        validateLottoRange(numbers);
    }

    private void validateLottoCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_DUPLICATION.getMessage());
        }
    }

    private void validateLottoRange(List<Integer> numbers) {
        numbers.forEach(this::validateLottoNumberRange);
    }

    private void validateLottoNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
