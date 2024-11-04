package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        lottoPurchase.start();

        WinningNumbersInput winningNumbersInput = new WinningNumbersInput();
        List<Integer> winningNumbers = winningNumbersInput.inputWinningNumbers();

        BonusNumberInput bonusNumberInput = new BonusNumberInput();
        int bonusNumber = bonusNumberInput.inputBonusNumber(winningNumbers);

        List<Lotto> userLottos = lottoPurchase.getUserLottos();
        WinningResultCalculator calculator = new WinningResultCalculator();
        Map<Rank, Integer> results = calculator.calculateResults(userLottos, winningNumbers, bonusNumber);

        calculator.printResults(results);

        double profitRate = calculator.calculateProfitRate(results, lottoPurchase.getTotalCost());
        calculator.printProfitRate(profitRate);
    }
}
