package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.exception.lotto.LottoNumberCountInvalidException;
import lotto.exception.lotto.LottoNumberDuplicatedException;

final public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Number> numbers;

    public Lotto(final List<Number> numbers) {
        validateNumbersCount(numbers);
        validateNumbersNotDuplicated(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private static void validateNumbersCount(List<Number> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new LottoNumberCountInvalidException(LOTTO_NUMBER_COUNT);
        }
    }

    private static void validateNumbersNotDuplicated(List<Number> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new LottoNumberDuplicatedException();
        }
    }

    private static boolean hasDuplicatedNumber(List<Number> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }
}
