package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
        Set<Integer> number = new HashSet<>(numbers);
        if (number.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    public long compareNumbers(List<Integer> winningNumbers, Map<String, Integer> winningDetail) {
        int count = 0;
        count = compareWinningNumbers(winningNumbers, count);
        count = compareBonusNumber(winningNumbers, count);
        Long winning = winningCheck(winningDetail, count);
        if (winning != null) {
            return winning;
        }
        return 0;
    }

    private int compareWinningNumbers(List<Integer> winningNumbers, int count) {
        for (int i = 0; i < winningNumbers.size() - 1; i++) {
            if (numbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int compareBonusNumber(List<Integer> winningNumbers, int count) {
        if (count == 5 && numbers.contains(winningNumbers.getLast())) {
            count *= 2;
        }
        return count;
    }

    private Long winningCheck(Map<String, Integer> map, int count) {
        Winning[] winnings = Winning.values();
        for (Winning winning : winnings) {
            if (winning.getCount() == count) {
                map.put(winning.getMean(), map.get(winning.getMean()) + 1);
                return winning.getWinningPrice();
            }
        }
        return null;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
