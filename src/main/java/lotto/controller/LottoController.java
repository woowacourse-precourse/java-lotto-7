package lotto.controller;

import static lotto.constant.ApplicationConstants.LOTTO_PRICE;

import java.util.List;
import lotto.domain.BonuseNumber;
import lotto.domain.Lotto;
import lotto.enums.LottoRank;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPurchaseService lottoPurchaseService;
    private final LottoResultService lottoResultService;

    public LottoController(InputView inputView, OutputView outputView, LottoPurchaseService lottoPurchaseService,
                           LottoResultService lottoResultService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoPurchaseService = lottoPurchaseService;
        this.lottoResultService = lottoResultService;
    }

    public void run() {
        int purchaseAmount = inputView.getUserLottoPurchaseAmount();
        int lottoAmount = purchaseAmount / LOTTO_PRICE;

        List<Lotto> purchaseLottos = lottoPurchaseService.purchaseLottos(lottoAmount);
        outputView.printPurchaseLotts(purchaseLottos);

        Lotto winningLotto = inputView.getUserWinningLotto();
        BonuseNumber bonuseNumber = inputView.getUserBonusNumber(winningLotto);

        List<LottoRank> lottoResult = lottoResultService.calculateLottoResults(winningLotto, bonuseNumber,
                purchaseLottos);
        outputView.printLottoResult(lottoResult);

        double profit = lottoResultService.calculateProfitRate(lottoResult, purchaseAmount);
        outputView.printProfit(profit);

    }

}
