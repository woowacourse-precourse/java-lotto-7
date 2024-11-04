package lotto.domain;

import java.util.List;
import lotto.enums.Rank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
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
