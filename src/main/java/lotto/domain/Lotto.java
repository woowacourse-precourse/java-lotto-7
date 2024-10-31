package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.dto.LottoDto;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumbersRange(numbers);
        validateNumbersDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        boolean isValid = numbers.stream()
                .allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
        if (!isValid) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + MIN_NUMBER + "에서 " + MAX_NUMBER + " 사이여야 합니다.");
        }
    }

    private void validateNumbersDuplicated(List<Integer> numbers) {
        long uniqueCount = numbers.stream()
                .distinct()
                .count();
        if (uniqueCount != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
        }
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }

    public int getMatchingCount(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::isContainNumber)
                .count();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
