package lotto.domain.lotto;

import lotto.constants.ErrorMessage;
import lotto.domain.winning.WinningCombination;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
            }
        }
    }

    public Rank calculateRank(WinningCombination winningCombination) {
        int matchCount = (int) numbers.stream()
                .filter(winningCombination.winningNumbers().getWinningNumbers()::contains)
                .count();
        boolean bonusMatch = numbers.contains(winningCombination.bonusNumber().getBonusNumber());

        return Rank.valueOf(matchCount, bonusMatch);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}