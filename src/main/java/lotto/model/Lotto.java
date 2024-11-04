package lotto.model;

import static lotto.model.LottoConstants.LOTTO_NUMBERS_SIZE;
import static lotto.model.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.model.LottoConstants.MIN_LOTTO_NUMBER;

import java.util.List;
import lotto.exception.LottoValidationError;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortAscending(numbers);
    }

    public List<Integer> getAllNumbers() {
        return List.copyOf(numbers);
    }

    public boolean contains(final int value) {
        return numbers.contains(value);
    }

    public int countSameNumber(final Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::contains)
                .count();
    }

    private void validate(final List<Integer> numbers) {
        checkCountOfLottoNumbers(numbers.size());
        checkMinimumOfLottoNumber(numbers);
        checkMaximumOfLottoNumber(numbers);
        checkDuplicatedNumbers(numbers);
    }

    private void checkCountOfLottoNumbers(final int size) {
        if (size != LOTTO_NUMBERS_SIZE) {
            LottoValidationError.INVALID_LOTTO_NUMBERS_COUNT.throwException(LOTTO_NUMBERS_SIZE);
        }
    }

    private void checkMinimumOfLottoNumber(final List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < MIN_LOTTO_NUMBER)
                .findAny()
                .ifPresent(invalidNumber ->
                        LottoValidationError.LOTTO_NUMBER_BELOW_MINIMUM.throwException(MIN_LOTTO_NUMBER)
                );
    }

    private void checkMaximumOfLottoNumber(final List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number > MAX_LOTTO_NUMBER)
                .findAny()
                .ifPresent(invalidNumber ->
                        LottoValidationError.LOTTO_NUMBER_ABOVE_MAXIMUM.throwException(MAX_LOTTO_NUMBER));
    }

    private void checkDuplicatedNumbers(final List<Integer> numbers) {
        final long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (distinctCount != numbers.size()) {
            LottoValidationError.DUPLICATED_LOTTO_NUMBERS_EXISTS.throwException();
        }
    }

    private List<Integer> sortAscending(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
