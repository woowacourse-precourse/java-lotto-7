package lotto.domain.lotto;

import lotto.domain.number.WinningNumbers;

public record WinningLotto(
        Lotto lotto,
        LottoRank rank
) {
    public static WinningLotto createWinningLotto(
            final Lotto lotto,
            final WinningNumbers winningNumbers,
            final int bonusNumber
    ) {
        int matchCount = getMatchCount(lotto, winningNumbers);
        boolean hasBonusNumber = hasBonusNumber(lotto, bonusNumber);
        LottoRank rank = LottoRank.getLottoRank(matchCount, hasBonusNumber);

        return new WinningLotto(lotto, rank);
    }

    private static boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers()
                .contains(bonusNumber);
    }

    private static int getMatchCount(Lotto lotto, WinningNumbers winningNumbers) {
        return winningNumbers.countMatchedNumbers(lotto.getNumbers());
    }
}