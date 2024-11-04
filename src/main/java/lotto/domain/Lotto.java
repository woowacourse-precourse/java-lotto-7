package lotto.domain;

import static lotto.constant.LottoConstants.REQUIRED_NUMBER_COUNT;
import static lotto.exception.ExceptionMessage.*;

import java.util.*;
import lotto.util.LottoUtils;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateNoDuplicates(numbers);
        this.numbers = List.copyOf(numbers.stream().sorted().toList());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_LIMIT.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            LottoUtils.validateRange(number);
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public int countMatchNumber(Lotto winLotto) {
        return (int) numbers.stream().filter(winLotto.numbers::contains).count();
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
