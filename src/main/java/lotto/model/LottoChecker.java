package lotto.model;

import java.util.List;

public class LottoChecker {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoChecker(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningRank countMatchingNumbers(Lotto lotto) {
        int matchCount = (int) lotto.getNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();

        boolean matchBonus = matchCount == 5 && lotto.getNumbers().contains(bonusNumber);

        return WinningRank.findRank((int) matchCount, matchBonus);
    }

}
