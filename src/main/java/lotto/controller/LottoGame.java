package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.service.LottoPurchase;
import lotto.service.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchase lottoPurchase;

    public LottoGame(InputView inputView, OutputView outputView, LottoPurchase lottoPurchase) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoPurchase = lottoPurchase;
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
