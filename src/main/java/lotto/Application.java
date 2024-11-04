package lotto;

import lotto.controller.OutputController;
import lotto.model.Lotto;
import lotto.view.*;

import java.util.List;

//import Lotto;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int price = InputView.purchaseAmount();
        int purchaseQuantity = price/1000;
        InputView.printPurchaseQuantity(price);

        List<List<Integer>> lottoNumbersList= OutputController.getLottoNumbers(purchaseQuantity);
        OutputView.printLottoNumbers(lottoNumbersList);
        List<Integer> winningNumbers = InputView.winningNumber();
        int bonusNubmer = InputView.bonusNumber();

        Lotto.validateDuplicationBetweenWinningAndBonus(winningNumbers, bonusNubmer);

       // List<List<Integer>> lottoNumbersList= OutputController.getLottoNumbers(purchaseQuantity);
        //OutputView.printLottoNumbers(lottoNumbersList);
        int[] matchPoints = OutputController.calculateStatistics(winningNumbers, lottoNumbersList);
        int totalPrize = OutputController.calculateTotalPrize(matchPoints);
        double profitRate = OutputController.calculateProfit(price, totalPrize);

        OutputView.printWinningStatistics(matchPoints, profitRate);


    }
}
