package lotto.domain;

import java.util.List;
import lotto.enums.Rank;

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
    }

    public int calculateRank(List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = numbers.stream().filter(winningNumbers::contains).count();
        boolean bonusNumberFlag = numbers.contains(bonusNumber);
        return Rank.calculate(matchCount, bonusNumberFlag);
    }

    @Override
    public String toString() {
        return numbers.stream().sorted().toList().toString();
    }
}
