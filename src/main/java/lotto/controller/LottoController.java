package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Issuer;
import lotto.model.LottoResult;
import lotto.model.Statistics;
import lotto.parser.InputParser;
import lotto.validator.LottoPurchaseValidator;
import lotto.view.ConsoleView;

public class LottoController {
    private final LottoPurchaseValidator lottoPurchaseValidator;
    private final InputParser inputParser;
    private final ConsoleView consoleView;
    private final Issuer issuer;

    public LottoController(LottoPurchaseValidator lottoPurchaseValidator, InputParser inputParser, ConsoleView consoleView, Issuer issuer) {
        this.lottoPurchaseValidator = lottoPurchaseValidator;
        this.inputParser = inputParser;
        this.consoleView = consoleView;
        this.issuer = issuer;
    }

    public void run() {
        Integer purchaseAmount = getPurchaseLottoAmount();

        List<Lotto> issuedLotteries = getLotteries(purchaseAmount);

        List<Integer> winningNumbers = consoleView.getWinningNumbers();
        Integer bonusNumbers = consoleView.getBonusNumber();

        Statistics statistics = new Statistics(winningNumbers, bonusNumbers);

        Map<LottoResult, Integer> lottoResults = getLottoResults(statistics, issuedLotteries);

        Float rateOfReturn = getRateOfReturn(statistics, lottoResults);
        consoleView.printRateOfReturn(rateOfReturn);
    }

    private Float getRateOfReturn(Statistics statistics, Map<LottoResult, Integer> lottoResults) {
        return statistics.getRateOfReturn(lottoResults);
    }

    private Map<LottoResult, Integer> getLottoResults(Statistics statistics, List<Lotto> issuedLotteries) {
        Map<LottoResult, Integer> lottoResults = statistics.getResult(issuedLotteries);
        consoleView.printStatistics(lottoResults);
        return lottoResults;
    }

    private List<Lotto> getLotteries(Integer purchaseAmount) {
        List<Lotto> issuedLotteries = issuer.issueLotto(purchaseAmount);
        consoleView.printIssuedLotto(issuedLotteries);
        return issuedLotteries;
    }

    private Integer getPurchaseLottoAmount() {
        while (true) {
            try {
                String userInputPurchase = consoleView.getPurchaseLottoAmount();
                lottoPurchaseValidator.validate(userInputPurchase);
                return inputParser.parseInput(userInputPurchase);
            } catch (IllegalArgumentException e) {
                consoleView.printErrorMessage(e.getMessage());
            }
        }
    }
}
