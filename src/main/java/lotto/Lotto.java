package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int NUM_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUM_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되지 않아야 합니다.");
        }
    }

    public void matchNumbers(Lotto winningNumber, int bonusNumber) {
        winningNumber.matchNumbers(this.numbers, bonusNumber);
    }

    public void matchNumbers(List<Integer> numbers, int bonusNumber) {
        int matchCount = 0;
        for (int number : numbers) {
            if (this.numbers.contains(number)) {
                matchCount++;
            }
        }

        if (matchCount == 5) {
            if (numbers.contains(bonusNumber)) {
                Winning.SECOND.count();
                return;
            }
        }
        Winning.findByMatch(matchCount).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
