package lotto.presentation.controller;

import lotto.presentation.input.InputHandler;
import lotto.dto.LottoResults;
import lotto.presentation.view.View;
import lotto.model.Lotto;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;

public class LottoController {
    private final InputHandler inputHandler;
    private final View view;
    private final LottoService lottoService;

    public LottoController(InputHandler inputHandler, LottoService lottoService, View view) {
        this.inputHandler = inputHandler;
        this.lottoService = lottoService;
        this.view = view;
    }

    public void run() {
        LottoPurchase lottoPurchase = purchaseLotto();
        WinningNumbers winningNumbers = issueWinningNumbers();

        Lottos lottos = generateLottos(lottoPurchase);
        displayLottos(lottoPurchase, lottos);

        LottoResults lottoResults = calculateLottoResults(lottos, winningNumbers, lottoPurchase);
        displayResults(lottoResults);
    }

    private LottoResults calculateLottoResults(Lottos lottos, WinningNumbers winningNumbers, LottoPurchase lottoPurchase) {
        return lottoService.calculateResults(lottos, winningNumbers, lottoPurchase);
    }

    private void displayResults(LottoResults lottoResults) {
        view.printWinningStatistics(lottoResults.getRankFrequency());
        view.printRevenue(lottoResults.getRevenue());
    }

    private void displayLottos(LottoPurchase lottoPurchase, Lottos lottos) {
        view.printPurchaseCount(lottoPurchase.getCount());
        view.printLottos(lottos);
    }

    private LottoPurchase purchaseLotto() {
        return inputHandler.handleLottoPurchase();
    }

    private WinningNumbers issueWinningNumbers() {
        Lotto winNumberLotto = inputHandler.handleWinNumbers();
        return inputHandler.handleBonusNumber(winNumberLotto);
    }

    private Lottos generateLottos(LottoPurchase lottoPurchase) {
        return lottoService.generateLottos(lottoPurchase.getCount());
    }
}
