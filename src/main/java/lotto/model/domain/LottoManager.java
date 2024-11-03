package lotto.model.domain;

public class LottoManager {

    private Lotto winningLotto;

    public Lotto saveWinningLotto(Lotto winningLotto) {
        return this.winningLotto = winningLotto;
    }
}