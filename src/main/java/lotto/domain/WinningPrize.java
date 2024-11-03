package lotto.domain;

import java.util.List;

public class WinningPrize {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningPrize(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoPrize getPrize(Lotto userLotto) {
        List<Integer> numbers = userLotto.getNumbers();
        int matchCount = calculateMatch(numbers);
        boolean bonusMatch = isBonusNumber(numbers);
        return LottoPrize.decidePrize(matchCount, bonusMatch);
    }

    private int calculateMatch(List<Integer> userNumbers) {
        return (int) userNumbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    private boolean isBonusNumber(List<Integer> userNumbers) {
        return userNumbers.contains(bonusNumber);
    }
}
