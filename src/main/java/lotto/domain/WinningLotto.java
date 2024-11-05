package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto getWinningNumber() {
        return lotto;
    }
}
