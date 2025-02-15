package lotto;

import java.util.EnumMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int lotteryPurchaseAmount = Initialize.InitializePurchaseAmount();
        List<Lotto> randomLotteryNumbers = LottoMachine.publishRandomLotteryNumbers(lotteryPurchaseAmount);
        LottoMachine.printRandomLotteryNumbers(randomLotteryNumbers);

        List<Integer> winningLotteryNumbers = Initialize.InitializeWinningLotteryNumbers();
        int bonusLotteryNumber = Initialize.InitializeBonusLotteryNumber(winningLotteryNumbers);

        EnumMap<LotteryPrize, Integer> prizeCount = LotteryResultChecker.lotteryResultChecker(winningLotteryNumbers, bonusLotteryNumber, randomLotteryNumbers);
        LotteryResult.printWinningResult(prizeCount);
        LotteryResult.printRateOfReturn(LotteryResult.calculateRateOfReturn(prizeCount, lotteryPurchaseAmount));
    }
}
