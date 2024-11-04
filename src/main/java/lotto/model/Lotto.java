package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ErrorMessage;
import lotto.constants.PrizeRank;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !isInRange(number))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);

        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE.getMessage());
        }
    }

    private boolean isInRange(int number) {
        return (number >= 0) && (number <= 45);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public PrizeRank getPrizeRank(WinningLotto winningLotto) {
        int matchCount = getMatchCount(winningLotto.lotto());
        boolean isBonusMatch = getIsBonusMatch(winningLotto.bonusNumber());

        return PrizeRank.getPrizeRankByMatchCountAndBonus(matchCount, isBonusMatch);
    }

    private int getMatchCount(Lotto winningLotto) {
        Set<Integer> set = new HashSet<>(winningLotto.getNumbers());

        return (int) numbers.stream()
                .filter(set::contains)
                .count();
    }

    private boolean getIsBonusMatch(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
