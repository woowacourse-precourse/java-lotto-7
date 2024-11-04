package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.requestPurchaseAmount();
        List<Lotto> lottos = LottoGenerator.generateLottos(purchaseAmount);

        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        List<Integer> winningNumbers = WinningNumberInput.requestWinningNumbers();
        int bonusNumber = BonusNumberInput.requestBonusNumber(winningNumbers);

        Map<Integer, Integer> resultCounts = LottoResultChecker.checkLottoResults(lottos, winningNumbers, bonusNumber);
        LottoProfitCalculator.calculateAndPrintProfit(purchaseAmount, resultCounts, resultCounts.getOrDefault(6, 0), resultCounts.getOrDefault(5, 0) - resultCounts.getOrDefault(5, 0));
    }



}
