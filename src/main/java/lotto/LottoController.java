package lotto;

import java.util.List;

public class LottoController {

    public void startGame() {
        int lottoPurchase = LottoInputView.lottoPurchaseAmount();
        List<Lotto> makePurchasedLottos = LottoFactory.createLottos(count(lottoPurchase));
        LottoOutputView.printPurchasedLottoCount(makePurchasedLottos);

        List<Integer> winningNumbers = LottoInputView.lottoWinningNumbers();
    }

    public int count (int lottoPurchase) {
        return (lottoPurchase / 1000);
    }
}
