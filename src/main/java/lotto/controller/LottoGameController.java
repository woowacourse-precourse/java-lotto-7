package lotto.controller;

import lotto.service.LottoPurchaseService;
import lotto.view.OutputView;
import lotto.view.InputView;

public class LottoGameController {
    private final LottoPurchaseService lottoGeneratorService;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.lottoGeneratorService = new LottoPurchaseService(inputView);
        this.outputView = outputView;
    }

    public void purchaseLotto() {
        int purchasedLottoCount = lottoGeneratorService.getPurchasedLottoCount();
        outputView.printPurchasedLottoCount(purchasedLottoCount);
    }
}
