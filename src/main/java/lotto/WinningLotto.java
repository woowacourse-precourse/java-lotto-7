package lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
}
