package lotto.lotto;

import java.util.List;
import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = convertFrom(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .mapToInt(Number::getValue)
                .boxed()
                .toList();
    }

    public boolean containsNumber(Number number) {
        return numbers.contains(number);
    }

    private List<Number> convertFrom(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::new)
                .toList();
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_SIZE.getValue()) {
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
