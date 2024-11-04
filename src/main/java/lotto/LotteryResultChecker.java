package lotto;

import java.util.EnumMap;
import java.util.List;

public class LotteryResultChecker {
    public static EnumMap<LotteryPrize, Integer> lotteryResultChecker(List<Integer> winningLotteryNumbers, int bonusLotteryNumber, List<Lotto> randomLotteryNumbers) {
        EnumMap<LotteryPrize, Integer> prizeCount = new EnumMap<>(LotteryPrize.class);
        matchCountCheck(winningLotteryNumbers, bonusLotteryNumber, randomLotteryNumbers);
        prizeCountCheck(randomLotteryNumbers, prizeCount);

        return prizeCount;
    }

    private static void matchCountCheck(List<Integer> winningLotteryNumbers, int bonusLotteryNumber, List<Lotto> randomLotteryNumbers) {
        for (Lotto randomLotteryNumber : randomLotteryNumbers) {
            int matchCount = 0;
            for (int i = 0; i < 6; i++) {
                if (randomLotteryNumber.getNumbers().contains(winningLotteryNumbers.get(i))) {
                    matchCount++;
                }
            }
            randomLotteryNumber.setMatchCount(matchCount);
            if (randomLotteryNumber.getNumbers().contains(bonusLotteryNumber)) {
                randomLotteryNumber.setCorrectBonusTrue();
            }
        }
    }

    private static void prizeCountCheck(List<Lotto> randomLotteryNumbers, EnumMap<LotteryPrize, Integer> prizeCount) {
        for (Lotto randomLotteryNumber : randomLotteryNumbers) {
            for (int i = 3; i <= 6; i++) {
                if (randomLotteryNumber.getMatchCount() == i) {
                    LotteryPrize matchCount = LotteryPrize.getPrizeByMatchCount(i, randomLotteryNumber.getCorrectBonus());
                    prizeCount.put(matchCount, prizeCount.getOrDefault(matchCount, 0) + 1);
                }
            }
        }
    }
}
