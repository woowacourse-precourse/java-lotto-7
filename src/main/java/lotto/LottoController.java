package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {
    public void run() {
        int amount = requestPurchaseAmount();
        Lottos lottos = new Lottos();
        lottos.issueByAmount(amount);
        OutputView.printPurchasedLottos(lottos);

        List<Integer> winningNumbers = requestWinningNumbers();
        int bonusNumber = requestBonusNumber(winningNumbers);

        Map<LottoRanking, Integer> compareResult = lottos.compareWinningNumbers(winningNumbers, bonusNumber);
        LottoResult lottoResult = new LottoResult(compareResult);
        OutputView.printWinningStatistics(lottoResult);

        double profitRate = lottoResult.calculateProfit(amount);
        OutputView.printProfitRate(profitRate);
    }

    private int requestPurchaseAmount() {
        while (true) {
            try {
                return InputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> requestWinningNumbers() {
        while (true) {
            try {
                return InputView.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int requestBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                return InputView.inputBonusNumber(winningNumbers);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
