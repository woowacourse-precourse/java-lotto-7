package lotto.domain;

import static lotto.error.ThrowException.throwIllegalArgumentException;
import static lotto.value.LottoValue.END_NUMBER_INCLUSIVE;
import static lotto.value.LottoValue.NUMBER_COUNT;
import static lotto.value.LottoValue.START_NUMBER_INCLUSIVE;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.error.Error;

public class Lotto {

    private final String DELIMITER = ", ";
    private final String PREFIX = "[";
    private final String SUFFIX = "]";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNaturalOrder(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        boolean validateCount = numbers.size() != NUMBER_COUNT.value();
        String errorFormat = Error.WRONG_LOTTO_NUMBER_COUNT.format(NUMBER_COUNT.value());
        throwIllegalArgumentException(validateCount, errorFormat);
    }

    private void validateDuplicate(List<Integer> numbers) {
        boolean validateDuplicate = numbers.stream().distinct().count() != numbers.size();
        String errorFormat = Error.DUPLICATE_LOTTO_NUMBER.getMessage();
        throwIllegalArgumentException(validateDuplicate, errorFormat);
    }

    private void validateRange(List<Integer> numbers) {
        final int startNumberInclusive = START_NUMBER_INCLUSIVE.value();
        final int endNumberInclusive = END_NUMBER_INCLUSIVE.value();
        boolean validateRange = !numbers.stream()
                .allMatch(number ->
                        (number >= startNumberInclusive) && (number <= endNumberInclusive));
        String errorFormat = Error.WRONG_LOTTO_NUMBER_RANGE.format(
                startNumberInclusive, endNumberInclusive);
        throwIllegalArgumentException(validateRange, errorFormat);
    }


    private List<Integer> sortNaturalOrder(List<Integer> numbers) {
        return numbers.stream().sorted(Comparator.naturalOrder()).toList();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public boolean containsAll(List<Integer> numbers) {
        return this.numbers.containsAll(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
