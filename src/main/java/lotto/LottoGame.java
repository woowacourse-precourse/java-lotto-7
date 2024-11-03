package lotto;

public class LottoGame {

    public void run() {
        LottoManager lottoManager = getLottoManager();
        do {
            WinningLotto winningLotto = InputHandler.inputWinningLottoNumbers();
        } while (true);
    }

    private LottoManager getLottoManager() {
        final int purchaseAmount = getPurchaseAmount();
        final int lottoAmount = purchaseAmount / 1000;
        return new LottoManager(lottoAmount);
    }

    private int getPurchaseAmount() {
        int purchaseAmount = InputHandler.inputLottoPurchaseAmount();
        while (purchaseAmount == 0) {
            purchaseAmount = InputHandler.inputLottoPurchaseAmount();
        }
        return purchaseAmount;
    }
}
