package lotto.controller.service;

import lotto.domain.Lottos;
import lotto.domain.Profit;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.domain.checker.WinningChecker;
import lotto.domain.constant.Ranking;
import lotto.io.output.ResultPrintHandler;

public class LottoGameService {

    private final ResultPrintHandler resultPrintHandler;

    public LottoGameService() {
        this.resultPrintHandler = new ResultPrintHandler();
    }

    public void playLotto(Lottos lottos, WinningLotto winningLotto) {
        WinningChecker winningChecker = new WinningChecker(lottos, winningLotto);
        Result results = winningChecker.checkWinning();
        printResult(results);
        int budget = lottos.getAmounts() * 1000;
        printProfitRate(results, budget);
    }

    private void printResult(Result results) {
        resultPrintHandler.printWinningStatics();
        resultPrintHandler.printFifthPrize(results.getResultCount(Ranking.FIFTH));
        resultPrintHandler.printFourthPrize(results.getResultCount(Ranking.FOURTH));
        resultPrintHandler.printThirdPrize(results.getResultCount(Ranking.THIRD));
        resultPrintHandler.printSecondPrize(results.getResultCount(Ranking.SECOND));
        resultPrintHandler.printFirstPrize(results.getResultCount(Ranking.FIRST));
    }

    private void printProfitRate(Result results, int budget) {
        Profit profit = Profit.from(results, budget);
        float profitRate = profit.calculateProfitRate();
        resultPrintHandler.printProfitRate(profitRate);
    }
}
