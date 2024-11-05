package lotto.domain;

import java.util.List;
import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.LottoNumberCountOutOfRangeException;
import lotto.exception.LottoNumberOutOfRangeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumbersOutOfRange(numbers);
        validateDuplicatedNumber(numbers);
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoNumberCountOutOfRangeException();
        }
    }

    private void validateNumbersOutOfRange(List<Integer> numbers) {
        numbers.stream().forEach(number -> {
                    if (number > 45 || number < 1) {
                        throw new LottoNumberOutOfRangeException();
                    }
                }
        );
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != 6) {
            throw new DuplicatedLottoNumberException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
