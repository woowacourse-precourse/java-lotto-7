package lotto.lotto;

import java.util.List;
import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = convertFrom(numbers);
    }

    private List<Number> convertFrom(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::new)
                .toList();
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new CustomException(ExceptionMessage.INVALID_LOTTO_SIZE_EXCEPTION);
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();

        if (count != numbers.size()) {
            throw new CustomException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER_EXCEPTION);
        }
    }
}
