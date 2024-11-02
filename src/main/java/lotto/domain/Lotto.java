package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int NUMBER_SIZE = 6;
    private static final String INVALID_NUMBER_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public int countMatchNumbers(WinningNumbers winningNumbers) {
        return (int) this.numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean matchBonusNumber(BonusNumber bonusNumber) {
        return this.numbers.contains(bonusNumber.getNumber());
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }
}