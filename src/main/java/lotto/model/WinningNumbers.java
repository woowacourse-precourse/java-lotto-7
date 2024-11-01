package lotto.model;

public class WinningNumbers {
    private static WinningNumbers instance;
    private final Lotto winningLotto;
    private final int bonusNumber;

    private WinningNumbers(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers getInstance(Lotto winningLotto, int bonusNumber) {
        if (instance == null) {
            instance = new WinningNumbers(winningLotto, bonusNumber);
        }
        return instance;
    }

    public static WinningNumbers getInstance() {
        return instance;
    }

    public int getMatchCount(Lotto lotto) {
        return lotto.getMatchCount(winningLotto);
    }

    public boolean isBonusNumberMatched(Lotto lotto) {
        return lotto.isContained(bonusNumber);
    }
}
