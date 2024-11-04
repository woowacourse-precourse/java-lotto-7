package lotto.model;

import lotto.constant.LottoRank;

public class Checker {
    private final WinningNumbers winningNumbers;

    public Checker(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoResult check(Lotto lotto) {
        int matchCount = calculateWinningCount(lotto);
        boolean isMatchBonusCount = hasBonusMatch(lotto);

        LottoRank rank = LottoRank.findRank(matchCount, isMatchBonusCount);
        return new LottoResult(rank);
    }

    private int calculateWinningCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(winningNumbers.getWinningLottoNumber().getLottoNumbers()::contains)
                .count();
    }

    private boolean hasBonusMatch(Lotto lotto) {
        return lotto.getLottoNumbers().contains(winningNumbers.getBonusLottoNumber());
    }
}