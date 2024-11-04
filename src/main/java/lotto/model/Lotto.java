package lotto.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.common.Constants;
import lotto.common.ErrorMessages;

public class Lotto implements Iterable<Integer> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_COUNT);
        }

        Set<Integer> removeDuplicates = new HashSet<>(numbers);
        if(removeDuplicates.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_DUPLICATED);
        }
    }

    public Map<Integer, Boolean> sameNumbersCount(WinningLotto winningLotto, int bonusNumber) {
        int matchedCount = 0;
        boolean matchedBonus = false;

        for (int winningNumber : winningLotto) {
            if (numbers.contains(winningNumber)) {
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
