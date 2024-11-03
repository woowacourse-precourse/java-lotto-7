package lotto.Domain;

public class LottoGame {
    private Lottos issuedLottos;
    private WinningNumbers winningNumbers;

    private LottoGame() {
    }

    public static LottoGame create() {
        return new LottoGame();
    }

    public void setIssuedLottos(Lottos lottos) {
        this.issuedLottos = lottos;
    }

    public void setWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

}
