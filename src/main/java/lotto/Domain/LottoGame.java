package lotto.Domain;

public class LottoGame {
    private Lottos issuedLottos;
    private WinningNumbers winningNumbers;
    private WinningResult winningResult;
    private int amount;

    private LottoGame() {
        winningResult = WinningResult.create();
    }

    public static LottoGame create() {
        return new LottoGame();
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setWinningResult(WinningResult winningResult) {
        this.winningResult = winningResult;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Lottos getIssuedLottos() {
        return issuedLottos;
    }

    public void setIssuedLottos(Lottos lottos) {
        this.issuedLottos = lottos;
    }

    public double calculateProfit() {
        int totalPrize = 0;
        for (WinningRules rule : WinningRules.values()) {
            totalPrize += rule.getPrize() * winningResult.getCount(rule);
        }
        return ((double) totalPrize / amount) * 100;
    }

}
