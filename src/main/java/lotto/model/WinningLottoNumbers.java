package lotto.model;

public class WinningLottoNumbers {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLottoNumbers(Lotto winningLotto, int bonusNumber) {
        this.lotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
}
