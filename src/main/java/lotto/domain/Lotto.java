package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Prize prize;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private List<Integer> sortNumbers(List<Integer> unmodifiable) {
        List<Integer> modifiable = new ArrayList<>(unmodifiable);
        Collections.sort(modifiable);
        return modifiable;
    }

    public void getResult(List<Integer> winningNums, int bonusNum) {
        int matchCounts = findMatchCounts(winningNums);
        if (matchCounts == Prize.SECOND.getStandard()) {
            setPrize(Prize.findResult(matchCounts, numbers.contains(bonusNum)));
            return;
        }
        setPrize(Prize.findResult(matchCounts, false));
    }

    private int findMatchCounts(List<Integer> winningNums) {
        int count = 0;
        for (int num : numbers) {
            if (winningNums.contains(num)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Prize getPrize() {
        return prize;
    }

    private void setPrize(Prize prize) {
        this.prize = prize;
    }
}
