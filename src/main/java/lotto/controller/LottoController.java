package lotto.controller;

import java.util.Map;
import java.util.function.Consumer;
import lotto.constatnt.WinningRank;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoPrizeCalculator;
import lotto.service.PriceCalculator;
import lotto.service.RetryRunner;
import lotto.service.WinningNumberParser;
import lotto.view.input.PurchasePriceInput;
import lotto.view.input.WinningNumberInput;
import lotto.view.output.ResultDisplayer;

public class LottoController {

    private final PurchasePriceInput purchasePriceInput;
    private final PriceCalculator priceCalculator;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final ResultDisplayer resultDisplayer;
    private final WinningNumberParser winningNumberParser;
    private final WinningNumberInput winningNumberInput;
    private final LottoPrizeCalculator lottoPrizeCalculator;
    private final RetryRunner retryRunner;

    private int purchaseAmount;
    private Lotto parsedWinningNumbers;
    private int parsedWinningBonus;

    public LottoController(PriceCalculator priceCalculator, PurchasePriceInput purchasePriceInput, LottoNumberGenerator lottoNumberGenerator, ResultDisplayer resultDisplayer, WinningNumberParser winningNumberParser, WinningNumberInput winningNumberInput, LottoPrizeCalculator lottoPrizeCalculator, RetryRunner retryRunner) {
        this.purchasePriceInput = purchasePriceInput;
        this.priceCalculator = priceCalculator;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.resultDisplayer = resultDisplayer;
        this.winningNumberParser = winningNumberParser;
        this.winningNumberInput = winningNumberInput;
        this.lottoPrizeCalculator = lottoPrizeCalculator;
        this.retryRunner = retryRunner;
    }

    public void start() {
        retryRunner.runWithRetry(() -> purchaseAmount = getValidPurchaseAmount());
        retryRunner.runWithRetry(() -> parsedWinningNumbers = getValidParsedWinningNumbers());
        retryRunner.runWithRetry(() -> parsedWinningBonus = getValidParsedWinningBonus());

        Lottos generatedLottos = generateLottos(purchaseAmount);
        long totalPrize = lottoPrizeCalculator.calculateTotalPrize(generatedLottos, parsedWinningNumbers, parsedWinningBonus);
        double yield = lottoPrizeCalculator.calculateYield(totalPrize, purchaseAmount);

        Map<WinningRank, Integer> winningCounts = lottoPrizeCalculator.getWinningCounts();
        displayResults(winningCounts, yield);
    }

    private int getValidPurchaseAmount() {
        String price = purchasePriceInput.getPurchasePrice();
        return priceCalculator.parsePrice(price);
    }

    private Lotto getValidParsedWinningNumbers() {
        String winningNumber = winningNumberInput.getNumber();
        return winningNumberParser.splitWinningNumber(winningNumber);
    }

    private int getValidParsedWinningBonus() {
        String winningBonusNumber = winningNumberInput.getBonusNumber();
        return winningNumberParser.parseBonusWinningNumber(winningBonusNumber);
    }

    private Lottos generateLottos(int purchaseAmount) {
        int lottoCount = priceCalculator.calculateLotto(purchaseAmount);
        Lottos generatedLottos = lottoNumberGenerator.generateLottoNumbers(lottoCount);
        resultDisplayer.showPurchasedLottos(lottoCount, generatedLottos);
        return generatedLottos;
    }

    private void displayResults(Map<WinningRank, Integer> winningCounts, double yield) {
        resultDisplayer.showWinningStatistics(winningCounts);
        resultDisplayer.showYield(yield);
    }
}
