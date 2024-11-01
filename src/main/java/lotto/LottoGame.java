package lotto;

import java.util.List;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchase lottoPurchase;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoPurchase = new LottoPurchase();
    }

    public void start() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        List<Lotto> lottos = lottoPurchase.purchase(purchaseAmount);
        outputView.printLottos(lottos);

        LottoPrize lottoPrize = inputView.inputLottoPrize();
        LottoResult lottoResult = new LottoResult(lottos, lottoPrize, purchaseAmount);
        outputView.printLottoResult(lottoResult);
    }
}
