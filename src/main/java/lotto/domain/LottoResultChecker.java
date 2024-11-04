package lotto.domain;

public class LottoResultChecker {
    private final DrawnNumbers drawnNumbers;

    public LottoResultChecker(DrawnNumbers drawnNumbers) {
        this.drawnNumbers = drawnNumbers;
    }

    public int calculateMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(drawnNumbers.getWinningNumbers()::contains)
                .count();
    }

    public boolean hasBonusMatch(Lotto lotto) {
        return lotto.getNumbers()
                .contains(drawnNumbers.getBonusNumber().getValue());
    }
}
