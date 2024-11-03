package lotto.model;

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
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public void print() {
        System.out.println(numbers);
    }

    public Price compareWithWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> setNumbers = new HashSet<>(this.numbers);
        int matchCount = getMatchCount(setNumbers, winningNumbers);
        if (matchCount == 6) {
            return Price.FIRST;
        }
        if (matchCount == 5 && setNumbers.contains(bonusNumber)) {
            return Price.SECOND;
        }
        if (matchCount == 5) {
            return Price.THIRD;
        }
        if (matchCount == 4) {
            return Price.FORTH;
        }
        if (matchCount == 3) {
            return Price.FIFTH;
        }
        return Price.NONE;
    }

    private int getMatchCount(Set<Integer> setNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (setNumbers.contains(winningNumber)) {
                count += 1;
            }
        }
        return count;
    }
}
