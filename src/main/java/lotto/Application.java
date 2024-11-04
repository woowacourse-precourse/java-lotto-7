package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = InputView.requestPurchaseAmount();
            List<Lotto> lottos = LottoGenerator.generateLottos(purchaseAmount);

            System.out.printf("%d개를 구매했습니다.\n", lottos.size());
            for (Lotto lotto : lottos) {
                System.out.println(lotto);
            }

            List<Integer> winningNumbers = WinningNumberInput.requestWinningNumbers();
            int bonusNumber = BonusNumberInput.requestBonusNumber(winningNumbers);

            Map<Integer, Integer> resultCounts = LottoResultChecker.checkLottoResults(lottos, winningNumbers, bonusNumber);
            LottoProfitCalculator.calculateAndPrintProfit(
                    purchaseAmount,
                    resultCounts,
                    resultCounts.getOrDefault(6, 0),
                    resultCounts.getOrDefault(5, 0) - resultCounts.getOrDefault(5, 0)
            );

        } catch (IllegalArgumentException e) {
            // 예외 메시지를 콘솔에 출력하고 프로그램 종료
            System.out.println(e.getMessage());
        }
    }
}
