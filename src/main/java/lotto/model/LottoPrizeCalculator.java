package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoPrizeCalculator {
    private static final LottoPrizeCalculator instance = new LottoPrizeCalculator();
    private int totalAmount = 0;

    private LottoPrizeCalculator() {
    }

    public static LottoPrizeCalculator getInstance() {
        return instance;
    }

    public Map<Prize, Integer> calculate(LottoTickets lottoTickets, WinningLotto winningLotto) {
        Map<Prize, Integer> prizeCountMap = new HashMap<>();
        totalAmount = 0;

        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            Prize prize = determinePrize(lotto.getNumbers(), winningLotto);
            if (prize != null) {
                prizeCountMap.put(prize, prizeCountMap.getOrDefault(prize, 0) + 1);
                totalAmount += prize.getPrizeMoney();
            }
        }
        return prizeCountMap;
    }

    public double calculateProfitRatio(int attemptCount) {
        double totalCost = attemptCount * 1000.0;
        return (totalAmount / totalCost) * 100.0;
    }

    private Prize determinePrize(List<Integer> lottoNumbers, WinningLotto winningLotto) {
        List<Integer> winningNumber = winningLotto.getWinningNumber();
        int matchCount = countMatches(lottoNumbers, winningNumber);
        boolean matchBonus = (matchCount == 5) && lottoNumbers.contains(winningLotto.getBonusNumber());

        return Prize.valueOf(matchCount, matchBonus);
    }

    private int countMatches(List<Integer> lottoNumbers, List<Integer> winningNumber) {
        List<Integer> mutableLottoNumbers = new ArrayList<>(lottoNumbers);
        mutableLottoNumbers.retainAll(winningNumber);
        return mutableLottoNumbers.size();
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
