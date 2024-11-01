package lotto.domain;

public class LottoGame {
    private final Lottos lottos;
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public LottoGame(Lottos lottos, Lotto winningLotto, BonusNumber bonusNumber) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
