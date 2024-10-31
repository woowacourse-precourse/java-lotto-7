package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNoDuplicates(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() < 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || 45 < number) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 값이어야 합니다.");
            }
        }
    }

    public int calculatePrize(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> WINNING_PRIZES = List.of(0, 0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000);
        int matchingCount = 0;
        for (int number : winningNumbers) {
            if (this.numbers.contains(number)) {
                matchingCount++;
            }
        }
        if (matchingCount == 5 && this.numbers.contains(bonusNumber)) {
            return WINNING_PRIZES.get(7);
        }
        return WINNING_PRIZES.get(matchingCount);
    }
    // TODO: 추가 기능 구현
}
