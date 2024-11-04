package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchaseHandler.printRequestingMoneyInput();
        String moneyInput = InputHandler.getUserInput();
        int paymentAmount = LottoPurchaseHandler.getValidatedPaymentAmount(moneyInput);
        int lottoPurchaseCount = LottoPurchaseHandler.getLottoPurchaseCount(paymentAmount);

        List<List<Integer>> randomLottoBundle = new ArrayList<>();
        LottoPurchaseHandler.getRandomLottoBundle(lottoPurchaseCount, randomLottoBundle);

        Lotto.printRequestingLottoWinningNumbers();
        String numbersInput = InputHandler.getUserInput();
        Lotto winningNumbers = Lotto.getWinningNumbers(numbersInput);

        Lotto.printRequestingBonusNumber();
        String numberInput = InputHandler.getUserInput();
        int bonusNumber = Lotto.getBonusNumber(winningNumbers, numberInput);

        List<Integer> prizeCount = new ArrayList<>(List.of(0, 0, 0, 0, 0));

        for (List<Integer> randomNumbers : randomLottoBundle) {
            int numberMatchCount = Lotto.numberMatchCount(winningNumbers, randomNumbers);
            boolean matchBonusNumber = randomNumbers.contains(bonusNumber);

            LottoPrize.getIndividualResult(numberMatchCount, matchBonusNumber, prizeCount);
        }

        LottoPrize.printResult(prizeCount);

        LottoPrize.calculateProfitRate(prizeCount, paymentAmount);
    }
}