package lotto;

import java.util.List;

public class LottoController {

    public void startGame() {
        int lottoPurchase = LottoInputView.lottoPurchaseAmount();
        List<Lotto> makePurchasedLottos = LottoFactory.createLottos(count(lottoPurchase));
        LottoOutputView.printPurchasedLottoCount(makePurchasedLottos);
    }

    public int count (int lottoPurchase) {
        return (lottoPurchase / 1000);
    }
}
