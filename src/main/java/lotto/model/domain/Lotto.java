package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoInfo;
import lotto.exception.ErrorStatus;
import lotto.exception.handler.LottoErrorHandler;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoInfo.LOTTO_SIZE.getValue()) {
            throw new LottoErrorHandler(ErrorStatus.LOTTO_SIZE_ERROR);
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(num -> num < LottoInfo.LOTTO_MIN_LIMIT.getValue()
                        || num > LottoInfo.LOTTO_MAX_LIMIT.getValue());
        if (isOutOfRange) {
            throw new LottoErrorHandler(ErrorStatus.LOTTO_OUT_RANGE_ERROR);
        }
    }

    private void validateUnique(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();
        if (count != LottoInfo.LOTTO_SIZE.getValue()) {
            throw new LottoErrorHandler(ErrorStatus.LOTTO_UNIQUE_ERROR);
        }
    }

    @Override
    public String toString() {
        return "[" +
                getNumbers().stream()
                        .map(String::valueOf)
                        .reduce((number1, number2) -> number1 + ", " + number2)
                        .orElseThrow()
                + ']';
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
