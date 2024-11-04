package lotto;

import java.util.List;

public class LottoResult {
    private final Lotto lotto;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        this.lotto = lotto;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank() {
        int matchCount = countMatchNumbers();
        return Rank.valueOf(matchCount, hasMatchBonus(matchCount));
    }

    private int countMatchNumbers() {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean hasMatchBonus(int matchCount) {
        if (matchCount != 5) {
            return false;
        }
        return lotto.getNumbers().contains(bonusNumber);
    }
}
