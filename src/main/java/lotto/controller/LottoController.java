package lotto.controller;

import java.util.Map;
import lotto.constatnt.WinningRank;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoPrizeCalculator;
import lotto.service.PriceCalculator;
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

    public LottoController(PriceCalculator priceCalculator, PurchasePriceInput purchasePriceInput, LottoNumberGenerator lottoNumberGenerator, ResultDisplayer resultDisplayer, WinningNumberParser winningNumberParser, WinningNumberInput winningNumberInput, LottoPrizeCalculator lottoPrizeCalculator) {
        this.purchasePriceInput = purchasePriceInput;
        this.priceCalculator = priceCalculator;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.resultDisplayer = resultDisplayer;
        this.winningNumberParser = winningNumberParser;
        this.winningNumberInput = winningNumberInput;
        this.lottoPrizeCalculator = lottoPrizeCalculator;
    }

    public void start() {
        int purchaseAmount = getValidPurchaseAmount();
        Lottos generatedLottos = generateLottos(purchaseAmount);
        Lotto parsedWinningNumbers = getValidParsedWinningNumbers();
        int parsedWinningBonus = getValidParsedWinningBonus();

        long totalPrize = lottoPrizeCalculator.calculateTotalPrize(generatedLottos, parsedWinningNumbers, parsedWinningBonus);
        double yield = lottoPrizeCalculator.calculateYield(totalPrize, purchaseAmount);

        Map<WinningRank, Integer> winningCounts = lottoPrizeCalculator.getWinningCounts();
        displayResults(winningCounts, yield);
    }

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                String price = purchasePriceInput.getPurchasePrice();
                return priceCalculator.parsePrice(price);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getValidParsedWinningNumbers() {
        while (true) {
            try {
                String winningNumber = winningNumberInput.getNumber();
                return winningNumberParser.splitWinngNumber(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidParsedWinningBonus() {
        while (true) {
            try {
                String winningBonusNumber = winningNumberInput.getBonusNumber();
                return winningNumberParser.parseBonusWinningNumber(winningBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
