package lotto.model;

public interface LottoWinningStrategy {
    boolean isWinning(WinningLotto winningLotto, Lotto myLotto, BonusNumber bonusNumber);

    int getConditionOfMatchCount();

    boolean isBonusNumberRequired();

    default int getMatchCount(WinningLotto winningLotto, Lotto myLotto) {
        int count = 0;
        for (int i = 0; i < winningLotto.getSize(); i++) {
            for (int j = 0; j < myLotto.getSize(); j++) {
                if (winningLotto.getWinNumbers().get(i).equals(myLotto.getNumbers().get(j))) {
                    count++;
                }
            }
        }
        return count;
    }
}
