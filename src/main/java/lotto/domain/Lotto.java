package lotto.domain;

import static java.lang.String.format;
import static lotto.constant.LottoGameRule.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoGameRule.MIN_LOTTO_NUMBER;
import static lotto.constant.LottoGameRule.NUMBER_OF_PICKS;
import static lotto.exception.ErrorMessage.DUPLICATED_NUMBER;
import static lotto.exception.ErrorMessage.NUMBERS_SIZE_ERROR;
import static lotto.exception.ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE;

import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static void validate(List<Integer> numbers) {
        validateDuplicates(numbers);
        validateNumberRange(numbers);
        validateNumbersSize(numbers);
    }

    private static void validateDuplicates(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new LottoException(DUPLICATED_NUMBER);
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        if (isOutOfBounds(numbers)) {
            throw new LottoException(WINNING_NUMBER_OUT_OF_RANGE);
        }
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new LottoException(format(NUMBERS_SIZE_ERROR.getMessage(), NUMBER_OF_PICKS.getValue()));
        }
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private static boolean isOutOfBounds(List<Integer> numbers) {
        return !numbers.stream()
                .allMatch(num -> num >= MIN_LOTTO_NUMBER.getValue() &&
                        num <= MAX_LOTTO_NUMBER.getValue());
    }

    private static boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != NUMBER_OF_PICKS.getValue();
    }
}
