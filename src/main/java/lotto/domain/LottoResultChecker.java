package lotto.domain;

public class LottoResultChecker {
    private final DrawnNumbers drawnNumbers;

    public LottoResultChecker(DrawnNumbers drawnNumbers) {
        this.drawnNumbers = drawnNumbers;
    }

    public WinningResult check(Lottos lottos) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottos) {
            int matchCount = calculateMatchCount(lotto);
            boolean bonusMatch = hasBonusMatch(lotto);

            WinningType winningType = WinningType.valueOf(matchCount, bonusMatch);

            winningResult.addResult(winningType);
        }
        return winningResult;
    }

    private int calculateMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(drawnNumbers.getWinningNumbers()::contains)
                .count();
    }

    private boolean hasBonusMatch(Lotto lotto) {
        return lotto.getNumbers()
                .contains(drawnNumbers.getBonusNumber().getValue());
    }
}
