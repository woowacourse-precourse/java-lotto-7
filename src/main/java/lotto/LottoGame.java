package lotto;

public class LottoGame {

    public void play() {
        PurchaseAmount purchaseAmount = InputHandler.getPurchaseAmount();

        int purchaseCount = purchaseAmount.getPurchaseCount();

        WinningLotto winningLotto = InputHandler.getWinningLotto();
    }
}
