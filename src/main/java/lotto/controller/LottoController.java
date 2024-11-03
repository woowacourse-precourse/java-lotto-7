package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningNumbers;
import lotto.domain.constant.Ranking;
import lotto.service.LottoService;
import lotto.view.InputProcessor;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.function.Supplier;

public class LottoController {

    private final LottoService lottoService;
    private final InputProcessor inputProcessor;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputProcessor inputProcessor, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputProcessor = inputProcessor;
        this.outputView = outputView;
    }

    public void run() {
        PurchasedLottos purchasedLottos = retryOnInvalidInput(this::getPurchasedLottos);
        drawResult(purchasedLottos);
    }

    private PurchasedLottos getPurchasedLottos() {
        Integer purchaseAmount = inputProcessor.processPurchaseLottos();
        PurchasedLottos purchasedLottos = lottoService.purchaseLottos(purchaseAmount);
        outputView.printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private void drawResult(PurchasedLottos purchasedLottos) {
        EnumMap<Ranking, Integer> statistics = getStatistics(purchasedLottos);
        double earningRate = lottoService.calculateEarningRate(purchasedLottos, statistics);
        outputView.printDrawResult(statistics, earningRate);
    }

    private EnumMap<Ranking, Integer> getStatistics(PurchasedLottos purchasedLottos) {
        Lotto winningNumber = retryOnInvalidInput(inputProcessor::processWinningNumber);
        WinningNumbers winningNumbers = retryOnInvalidInput(() -> {
            Integer bonusNumber = inputProcessor.processBonusNumber();
            return WinningNumbers.from(winningNumber, bonusNumber);
        });
        return lottoService.drawResult(purchasedLottos, winningNumbers);
    }

    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
