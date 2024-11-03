package lotto.domain;

public class WinningLotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(int bonusNumber, Lotto lotto) {
        this.bonusNumber = bonusNumber;
        this.lotto = lotto;
    }
}
