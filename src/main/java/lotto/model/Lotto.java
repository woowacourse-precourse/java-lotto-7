package lotto.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Lotto implements Iterable<Integer>{
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

    public Map<Integer, Boolean> sameNumbersCount(WinningLotto winningLotto, int bonusNumber) {
        int matchedCount = 0;
        boolean matchedBonus = false;
        for(int winningNumber : winningLotto) {
            if(numbers.contains(winningNumber)) {
                matchedCount++;
            }
        }
        if (numbers.contains(bonusNumber)) {
            matchedCount++;
            matchedBonus = true;
        }
        return Map.of(matchedCount, matchedBonus);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }
}
