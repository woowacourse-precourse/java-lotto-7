package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Issuer;
import lotto.model.LottoResult;
import lotto.model.Statistics;
import lotto.parser.InputParser;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoPurchaseValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.ConsoleView;

public class LottoController {
    private final LottoPurchaseValidator lottoPurchaseValidator;
    private final ConsoleView consoleView;
    private final Issuer issuer;
    private final WinningNumberValidator winningNumberValidator;
    private final BonusNumberValidator bonusNumberValidator;

    public LottoController(LottoPurchaseValidator lottoPurchaseValidator, WinningNumberValidator winningNumberValidator,
                           BonusNumberValidator bonusNumberValidator, ConsoleView consoleView, Issuer issuer) {
        this.lottoPurchaseValidator = lottoPurchaseValidator;
        this.winningNumberValidator = winningNumberValidator;
        this.bonusNumberValidator = bonusNumberValidator;
        this.consoleView = consoleView;
        this.issuer = issuer;
    }

    public void run() {
        Integer purchaseAmount = getPurchaseLottoAmount();

        List<Lotto> issuedLotteries = getLotteries(purchaseAmount);

        List<Integer> winningNumbers = getWinningNumbers();

        Integer bonusNumber = getBonusNumber();

        Statistics statistics = new Statistics(winningNumbers, bonusNumber);

        Map<LottoResult, Integer> lottoResults = getLottoResults(statistics, issuedLotteries);

        Float rateOfReturn = getRateOfReturn(statistics, lottoResults);
        consoleView.printRateOfReturn(rateOfReturn);
    }

    private List<Lotto> getLotteries(Integer purchaseAmount) {
        List<Lotto> issuedLotteries = issuer.getIssuedLotteries(purchaseAmount);
        consoleView.printIssuedLotto(issuedLotteries);
        return issuedLotteries;
    }

    private Integer getPurchaseLottoAmount() {
        while (true) {
            String userInputPurchase = consoleView.getPurchaseLottoAmount();
            try {
                lottoPurchaseValidator.validate(userInputPurchase);
                return InputParser.parseIntNumber(userInputPurchase);
            } catch (IllegalArgumentException e) {
                consoleView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            String winningNumbersInput = consoleView.getWinningNumbers();
            try {
                winningNumberValidator.validate(winningNumbersInput);
                return InputParser.parseIntNumbers(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                consoleView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Integer getBonusNumber() {
        while (true) {
            String bonusNumbersInput = consoleView.getBonusNumber();
            try {
                bonusNumberValidator.validate(bonusNumbersInput);
                return InputParser.parseIntNumber(bonusNumbersInput);
            } catch (IllegalArgumentException e) {
                consoleView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Float getRateOfReturn(Statistics statistics, Map<LottoResult, Integer> lottoResults) {
        return statistics.getRateOfReturn(lottoResults);
    }

    private Map<LottoResult, Integer> getLottoResults(Statistics statistics, List<Lotto> issuedLotteries) {
        Map<LottoResult, Integer> lottoResults = statistics.getResult(issuedLotteries);
        consoleView.printStatistics(lottoResults);
        return lottoResults;
    }
}
