package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoPurchaseService;
import lotto.view.OutputView;
import lotto.view.InputView;


import java.util.List;

public class LottoGameController {
    private final LottoPurchaseService lottoPurchaseService;
    private final OutputView outputView;
    private final LottoGeneratorService lottoGeneratorService;

    public LottoGameController(LottoPurchaseService lottoPurchaseService, OutputView outputView, LottoGeneratorService lottoGeneratorService) {
        this.lottoPurchaseService = lottoPurchaseService;
        this.outputView = outputView;
        this.lottoGeneratorService = lottoGeneratorService;
    }

    public void purchaseLotto() {
        int purchasedLottoCount;
        List<Lotto> lottos;

        purchasedLottoCount = lottoPurchaseService.getPurchasedLottoCount();
        outputView.printPurchasedLottoCount(purchasedLottoCount);
        lottos = lottoGeneratorService.generateLotto(purchasedLottoCount);
        outputView.printLottoNumbers(lottos);
    }
}
