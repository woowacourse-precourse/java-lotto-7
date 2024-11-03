package lotto.domain;

import static lotto.util.LottoValidator.*;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String NUMBER_DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public String createNumberInfo() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(NUMBER_DELIMITER));
    }

    public int countMatchingNumbers(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto.numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
    }
}