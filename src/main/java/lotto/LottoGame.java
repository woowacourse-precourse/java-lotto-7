package lotto;

public class LottoGame {

    public void run() {
        LottoManager lottoManager = getLottoManager();
        do {
            final WinningLotto winningLotto = InputHandler.inputWinningLottoNumbers();
        } while (true);
    }

    private LottoManager getLottoManager() {
        do {
            final int purchaseAmount = InputHandler.inputLottoPurchaseAmount();
            final int lottoAmount = purchaseAmount / 1000;
            return new LottoManager(lottoAmount);
        } while (true);
    }
}
