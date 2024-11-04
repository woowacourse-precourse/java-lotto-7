package lotto.domain;

import static lotto.service.exception.LottoExceptionMessage.INVALID_WINNING_NUMBERS;

import java.util.List;
import lotto.service.exception.LottoException;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(INVALID_WINNING_NUMBERS);
        }
    }

}