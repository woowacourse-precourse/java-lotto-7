package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningNumbers;
import lotto.domain.constant.Ranking;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.util.NumberParser;
import lotto.view.util.WinningNumberSplitter;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class LottoController {

    private final NumberParser numberParser;
    private final WinningNumberSplitter winningNumberSplitter;
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(NumberParser numberParser, WinningNumberSplitter winningNumberSplitter, LottoService lottoService, InputView inputView, OutputView outputView) {
        this.numberParser = numberParser;
        this.winningNumberSplitter = winningNumberSplitter;
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchasedLottos purchasedLottos = retryOnInvalidInput(this::getPurchasedLottos);
        outputView.printPurchasedLottos(purchasedLottos);
        EnumMap<Ranking, Integer> statistics = getStatistics(purchasedLottos);
        double earningRate = lottoService.calculateEarningRate(purchasedLottos, statistics);
        outputView.printDrawResult(statistics, earningRate);
    }

    private PurchasedLottos getPurchasedLottos() {
        String input = inputView.readPurchaseAmount();
        Integer purchaseAmount = numberParser.parseToInt(input);
        return lottoService.purchaseLottos(purchaseAmount);
    }

    private EnumMap<Ranking, Integer> getStatistics(PurchasedLottos purchasedLottos) {
        Lotto winningNumber = retryOnInvalidInput(this::getWinningNumber);
        WinningNumbers winningNumbers = retryOnInvalidInput(() -> getWinningNumbers(winningNumber));
        return lottoService.drawResult(purchasedLottos, winningNumbers);
    }

    private WinningNumbers getWinningNumbers(Lotto winningNumber) {
        Integer bonusNumber = retryOnInvalidInput(this::getBonusNumber);
        return WinningNumbers.from(winningNumber, bonusNumber);
    }

    private Lotto getWinningNumber() {
        String input = inputView.readWinningNumber();
        List<String> winningNumber = winningNumberSplitter.splitWinningNumber(input);
        return new Lotto(winningNumber.stream()
                .map(numberParser::parseToInt)
                .toList());
    }

    private Integer getBonusNumber() {
        String input = inputView.readBonusNumber();
        return numberParser.parseToInt(input);
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
