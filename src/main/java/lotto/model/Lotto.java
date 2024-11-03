package lotto.model;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw LottoException.from(ErrorMessage.LOTTO_NUMBERS_MUST_BE_SIX);
        }

        if (numbers.stream().distinct().count() != 6) {
            throw LottoException.from(ErrorMessage.LOTTO_NUMBERS_MUST_NOT_DUPLICATE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
