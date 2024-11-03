package lotto;

import java.util.List;

public class LottoGame {

    public void run() {
        LottoManager lottoManager = getLottoManager();
        final List<Integer> winningLottoNumbers = InputHandler.inputWinningLottoNumbers();
        final int bonusNumber = InputHandler.inputBonusNumber();
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
