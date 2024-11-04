package lotto.model;

public interface LottoWinningStrategy {
    boolean isWinning(WinningLotto winningLotto, Lotto myLotto, BonusNumber bonusNumber);

    int getConditionOfMatchCount();

    boolean isBonusNumberRequired();

    default int getMatchCount(WinningLotto winningLotto, Lotto myLotto) {
        return (int) winningLotto.getWinNumbers().stream()
                .filter(winNum -> myLotto.getNumbers().contains(winNum))
                .count();
    }
}
