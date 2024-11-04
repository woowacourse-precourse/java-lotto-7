package lotto.controller;

import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.domain.*;

import java.util.Map;

public class LottoController {

    public void run() {
        try {
            int purchaseAmount = InputView.getPurchaseAmount();
            LottoGenerator lottoGenerator = new LottoGenerator(purchaseAmount);
            Lottos lottos = new Lottos(lottoGenerator.generateLottos());
            printLottosInfo(lottoGenerator, lottos);
            WinningBonus winningBonus = new WinningBonus(InputView.getWinningNumber(), InputView.getBonusNumber());
            Map<Ranking, Integer> winningInfo = ProfitCalculator.getWinningInfo(lottos, winningBonus);
            printWinningInfo(winningInfo, purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printLottosInfo(LottoGenerator lottoGenerator, Lottos lottos) {
        OutputView.printNumberOfLotto(lottoGenerator.getLottoQuantity());
        OutputView.printLottos(lottos);
    }

    private void printWinningInfo(Map<Ranking, Integer> winningInfo, int purchaseAmount) {
        OutputView.printWinningStatistics();
        OutputView.printWinningInfo(winningInfo);
        int winningAmount = ProfitCalculator.getWinningAmount(winningInfo);
        OutputView.printProfit(ProfitCalculator.getLottoProfit(winningAmount, purchaseAmount));
    }
}
