package lotto;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.");
        }
    }

    public int match(Lotto winningLotto, int bonusNumber) {
        int matchCount = 0;
        boolean bonusMatch = numbers.contains(bonusNumber);

        for (int number : numbers) {
            if (winningLotto.numbers.contains(number)) {
                matchCount++;
            }
        }

        return matchCount == 5 && bonusMatch ? 7 : matchCount; // 7은 2등을 나타냄
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
