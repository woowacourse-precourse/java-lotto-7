package lotto.domain;

import lotto.exception.lotto.LottoErrorMessages;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_LOTTO_SIZE.getMessage());
        }
        Set<Integer> changeNumbers = new HashSet<>(numbers);
        if (changeNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoErrorMessages.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException(LottoErrorMessages.OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
