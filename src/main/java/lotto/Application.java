package lotto;

import lotto.controller.InputController;
import lotto.controller.OutputController;
import lotto.model.Lotto;
import lotto.view.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            try {
                int price = InputController.getPurchaseAmount();
                int purchaseQuantity = price / 1000;
                InputView.printPurchaseQuantity(price);

                List<List<Integer>> lottoNumbersList = OutputController.getLottoNumbers(purchaseQuantity);
                OutputView.printLottoNumbers(lottoNumbersList);
                List<Integer> winningNumbers = InputView.winningNumber();
                int bonusNumber = InputView.bonusNumber();
                Lotto.validateDuplicationBetweenWinningAndBonus(winningNumbers, bonusNumber);

                int[] matchPoints = OutputController.calculateStatistics(winningNumbers, lottoNumbersList);
                int totalPrize = OutputController.calculateTotalPrize(matchPoints);
                double profitRate = OutputController.calculateProfit(price, totalPrize);
                OutputView.printWinningStatistics(matchPoints, profitRate);

                break; // 모든 입력이 정상일 경우 루프 종료

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 오류 메시지 출력
                // 오류가 발생했으므로 루프를 계속하여 다시 입력 받기
            }
        }
    }
}
