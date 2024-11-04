package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        LottoInput input = new LottoInput();
        LottoGenerator generator = new LottoGenerator();
        LottoOutput output = new LottoOutput();
        LottoResultCalculator calculator = new LottoResultCalculator();

        try {
            int purchaseAmount = input.inputPurchaseAmount();
            List<Lotto> lottos = generator.generateLottos(purchaseAmount);
            output.printLottos(lottos);

            List<Integer> winningNumbers = input.inputWinningNumbers();
            int bonusNumber = input.inputBonusNumber();

            calculator.calculateResult(lottos, winningNumbers, bonusNumber);
            Map<String, Integer> results = calculator.getResults();

            output.printResults(results);
            double profitRate = calculateProfitRate(results, purchaseAmount);
            output.printProfit(profitRate);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static double calculateProfitRate(Map<String, Integer> results, int purchaseAmount) {
        double totalProfit = results.getOrDefault("1등", 0) * 2000000000 +
                results.getOrDefault("2등", 0) * 30000000 +
                results.getOrDefault("3등", 0) * 1500000 +
                results.getOrDefault("4등", 0) * 50000 +
                results.getOrDefault("5등", 0) * 5000;

        return (totalProfit / purchaseAmount) * 100;
    }
}
