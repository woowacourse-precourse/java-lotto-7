package lotto.controller;

import lotto.dto.response.LottosResponse;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.util.NumberParser;
import lotto.view.util.WinningNumberSplitter;

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
        LottosResponse lottosResponse = getPurchasedLottos();
        outputView.printPurchasedLottos(lottosResponse);
        List<Integer> winningNumber = getWinningNumber();
        Integer bonusNumber = getBonusNumber();
    }

    public List<Integer> getWinningNumber() {
        try {
            String input = inputView.readWinningNumber();
            List<String> winningNumber = winningNumberSplitter.splitWinningNumber(input);
            return winningNumber.stream()
                    .map(numberParser::parseToInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getWinningNumber();
        }
    }

    public Integer getBonusNumber() {
        return getValidatedInput(inputView::readBonusNumber);
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

    private Integer getValidatedInput(Supplier<String> inputReader) {
        try {
            String input = inputReader.get();
            return numberParser.parseToInt(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getValidatedInput(inputReader);
        }
    }
}
