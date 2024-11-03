package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoPrizeCalculator {
    private static int totalAmount = 0;

    public static Map<Prize, Integer> calculate(LottoTickets lottoTickets, WinningLotto winningLotto) {
        Map<Prize, Integer> prizeCountMap = new HashMap<>();
        totalAmount = 0;
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            Prize prize = comparePrize(lottoNumbers, winningLotto);

            if (prize != null) {
                prizeCountMap.put(prize, prizeCountMap.getOrDefault(prize, 0) + 1);
                totalAmount += prize.getPrizeMoney();
            }
        }
        return prizeCountMap;
    }

    public static double calculateProfitRatio(int attemptCount, int totalAmount) {
        double totalCost = attemptCount * 1000.0;
        return (totalAmount / totalCost) * 100.0;
    }

    private static Prize comparePrize(List<Integer> lottoNumbers, WinningLotto winningLotto) {
        List<Integer> winningNumber = winningLotto.getWinningNumber();
        lottoNumbers.retainAll(winningNumber);
        int matchCount = lottoNumbers.size();

        if (matchCount != 5) {
            return Prize.valueOf(matchCount, false);
        }

        int bonusNumber = winningLotto.getBonusNumber();
        boolean matchBonus = lottoNumbers.contains(bonusNumber);

        return Prize.valueOf(matchCount, matchBonus);
    }

    public static int getTotalAmount() {
        return totalAmount;
    }
}
