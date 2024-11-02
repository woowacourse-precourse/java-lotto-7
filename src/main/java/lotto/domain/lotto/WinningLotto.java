package lotto.domain.lotto;

import lotto.domain.number.WinningNumbers;

public class WinningLotto {

    private final LottoRank rank;

    private WinningLotto(final LottoRank rank) {
        this.rank = rank;
    }

    public static WinningLotto createWinningLotto(
            final Lotto lotto,
            final WinningNumbers winningNumbers,
            final int bonusNumber
    ) {
        int matchCount = getMatchCount(lotto, winningNumbers);
        boolean hasBonusNumber = hasBonusNumber(lotto, bonusNumber);

        return new WinningLotto(LottoRank.getLottoRank(matchCount, hasBonusNumber));
    }

    private static boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers()
                .contains(bonusNumber);
    }

    private static int getMatchCount(Lotto lotto, WinningNumbers winningNumbers) {
        return winningNumbers.countMatchedNumbers(lotto.getNumbers());
    }

    public LottoRank getRank() {
        return rank;
    }
}