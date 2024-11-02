package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.constant.Ranking;
import lotto.dto.response.LottosResponse;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.util.NumberParser;
import lotto.view.util.WinningNumberSplitter;

import java.util.EnumMap;
import java.util.List;

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
        LottosResponse lottosResponse = getPurchasedLottos();
        outputView.printPurchasedLottos(lottosResponse);
        EnumMap<Ranking, Integer> statistics = getStatistics();
        double earningRate = lottoService.calculateEarningRate(statistics);
        outputView.printDrawResult(statistics, earningRate);
    }

    private LottosResponse getPurchasedLottos() {
        try {
            String input = inputView.readPurchaseAmount();
            Integer purchaseAmount = numberParser.parseToInt(input);
            return lottoService.purchaseLottos(purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getPurchasedLottos();
        }
    }

    private EnumMap<Ranking, Integer> getStatistics() {
        Lotto winningNumber = getWinningNumber();
        return getBonusNumberAndDraw(winningNumber);
    }

    private EnumMap<Ranking, Integer> getBonusNumberAndDraw(Lotto winningNumber) {
        try {
            Integer bonusNumber = getBonusNumberAndDraw();
            return lottoService.drawResult(winningNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getBonusNumberAndDraw(winningNumber);
        }
    }

    private Lotto getWinningNumber() {
        try {
            String input = inputView.readWinningNumber();
            List<String> winningNumber = winningNumberSplitter.splitWinningNumber(input);
            return new Lotto(winningNumber.stream()
                    .map(numberParser::parseToInt)
                    .toList());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getWinningNumber();
        }
    }

    private Integer getBonusNumberAndDraw() {
        String input = inputView.readBonusNumber();
        return numberParser.parseToInt(input);
    }
}
