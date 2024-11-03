package lotto.view.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.global.exception.CustomException;
import lotto.view.global.exception.ErrorMessage;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto() {
        List<Integer> numbers = generateNumbers();
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
        Collections.sort(numbers);
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateUniqueNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw CustomException.of(ErrorMessage.INVALID_LOTTO_COUNT_ERROR);
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw CustomException.of(ErrorMessage.DUPLICATE_LOTTO_NUMBER_ERROR);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_NUMBER || number > MAX_NUMBER)) {
            throw CustomException.of(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    @Override
    public String toString() {
        return "[" + numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")) + "]";
    }
}
