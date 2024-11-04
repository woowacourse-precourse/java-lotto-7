package lotto.domain.lotto;

import static lotto.domain.lotto.constants.LottoFormat.*;
import static lotto.domain.lotto.constants.LottoNumber.*;
import static lotto.infrastructure.exception.ErrorCode.*;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateNoDuplicatedNumber(numbers);
        validateProperNumberRange(numbers);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT.getCriteria()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNoDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_COUNT.getCriteria()) {
            throw new IllegalArgumentException(INVALID_LOTTO_DUPLICATED_NUMBER.getMessage());
        }
    }

    private void validateProperNumberRange(List<Integer> numbers) {
        if (numbers.stream()
            .anyMatch(number -> number < MINIMUM_LOTTO_NUMBER.getCriteria()
	|| number > MAXIMUM_LOTTO_NUMBER.getCriteria())
        ) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return PREFIX_BRACKET.getFormat()
            + numbers.stream().map(String::valueOf)
            .collect(Collectors.joining(DELIMITER_WITH_SPACE.getFormat()))
            + SUFFIX_BRACKET.getFormat();
    }
}
