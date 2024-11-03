package lotto.Domain;

public class LottoGame {
    private Lottos lottos;
    private Lotto winningLotto;

    private LottoGame() {
    }

    public static LottoGame create() {
        return new LottoGame();
    }

    public void setIssuedLottos(Lottos lottos) {
        this.lottos = lottos;
    }

    public void setWinningLotto(Lotto lotto) {
        this.winningLotto = lotto;
    }

}
