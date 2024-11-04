package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lotto.model.Lotto;
import lotto.model.Issuer;
import lotto.model.LottoResult;
import lotto.model.Statistics;
import lotto.view.ConsoleView;

public class LottoController {
    private final ConsoleView consoleView;
    private final Issuer issuer;
    public LottoController(ConsoleView consoleView, Issuer issuer) {
        this.consoleView = consoleView;
        this.issuer = issuer;
    }

    public void run() {
        Integer purchaseAmount = getPurchaseLottoAmount();

        List<Lotto> issuedLotteries = getLotteries(purchaseAmount);

        List<Integer> winningNumbers = consoleView.getWinningNumbers();
        Integer bonusNumbers = consoleView.getBonusNumber();

        Statistics statistics = new Statistics(winningNumbers, bonusNumbers);
        Map<LottoResult, Integer> lottoResults = statistics.getResult(issuedLotteries);
        consoleView.printStatistics(lottoResults);

        Float rateOfReturn = statistics.getRateOfReturn(lottoResults);
        consoleView.printRateOfReturn(rateOfReturn);

    }

    private List<Lotto> getLotteries(Integer purchaseAmount) {
        List<Lotto> issuedLotteries = issuer.issueLotto(purchaseAmount);
        consoleView.printIssuedLotto(issuedLotteries);
        return issuedLotteries;
    }

    private Integer getPurchaseLottoAmount() {
        while (true) {
            try {
                return consoleView.getPurchaseLottoAmount();
            } catch (IllegalArgumentException e) {
                consoleView.printErrorMessage(e.getMessage());
            }
        }
    }
}
