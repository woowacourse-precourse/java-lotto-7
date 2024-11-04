package lotto.domain;

import lotto.message.ErrorMessage;
import lotto.util.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers); // 불변 리스트를 가변 리스트로 복사
        validate(numbers);
        sortAscending(numbers);
        this.numbers = numbers;
    }

    private void sortAscending(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    private void validate(List<Integer> numbers) {
        if (!Validation.isDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_PRESENT.getErrorMessage());
        }
        if (!Validation.isCorrectSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getErrorMessage());
        }
        if (!Validation.isCorrectRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}