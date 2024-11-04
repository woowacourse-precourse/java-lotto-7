package lotto.domain.Lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Number;

public class Lotto {
    private final List<Number> numbers;

    protected Lotto(List<Number> numbers) {
        validateLotto(numbers);
        this.numbers = sortLottoNumber(numbers);
    }

    private List<Number> sortLottoNumber(List<Number> numbers) {
        return numbers.stream()
                .sorted(Comparator.comparing(Number::getValue))
                .collect(Collectors.toList());
    }

    private void validateLotto(List<Number> numbers) {
        validateNumberSize(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateNumberSize(List<Number> numbers) {
        if (isValidNumberSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private boolean isValidNumberSize(List<Number> numbers) {
        return numbers.size() != 6;
    }

    private void validateDuplicatedNumber(List<Number> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Number number : numbers) {
            if (hasDuplicatedNumber(uniqueNumbers, number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
    }

    private boolean hasDuplicatedNumber(Set<Integer> uniqueNumbers, Number number) {
        return !uniqueNumbers.add(number.getValue());
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(number -> String.valueOf(number.getValue()))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public List<Number> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
