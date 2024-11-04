package lotto.domain;

import static lotto.domain.constant.ErrorMessage.DUPLICATED;
import static lotto.domain.constant.ErrorMessage.OUT_OF_RANGE;
import static lotto.domain.constant.ErrorMessage.VALUE_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.constant.LottoRank;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkDuplicate(numbers);
        checkRange(numbers);
    }

    private void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(VALUE_COUNT.getMessage());
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        numbers.forEach(s -> {
            if (s > 45 || s < 1) {
                throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
            }
        });
    }

    private int matchWinningNumbers(List<Integer> numbers) {
        return (int) this.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean matchBonusNumber(Integer number) {
        return numbers.contains(number);
    }

    public LottoRank getRank(Winning winning) {
        int matchingNumbers = matchWinningNumbers(winning.getNumbers());
        boolean isBonusMatch = matchBonusNumber(winning.getBonusNumber());

        return LottoRank.valueOf(matchingNumbers, isBonusMatch);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }

}
