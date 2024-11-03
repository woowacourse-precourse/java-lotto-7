package lotto.model;

import lotto.model.enums.Rank;

import java.util.List;
import java.util.Map;

public class LottoResults {
    private static Map<Rank, Integer> lottoStatics;
    private static double totalProfitRate;
    private final long purchaseAmount;
    private final List<Lotto> lottos;
    private final List<Integer> winnigNumbers;
    private final int BonusNumber;

    public LottoResults(long purchaseAmount, List<Lotto> lottos, List<Integer> winnigNumbers, int BonusNumber) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = lottos;
        this.winnigNumbers = winnigNumbers;
        this.BonusNumber = BonusNumber;
    }

    public void calResults() {
        lottoStatics = Rank.getRankCountMap();
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchedCnt = countMatchedNumbers(lottoNumbers);
            boolean isBonusMatched = checkMatchedBonusNumber();
            Rank rank = Rank.getRank(matchedCnt, isBonusMatched);
            int cnt = lottoStatics.getOrDefault(rank, 0);
            lottoStatics.put(rank, cnt + 1);
        }
        calTotalProfitRate();
    }

    public Map<Rank, Integer> getLottoStatics() {
        return lottoStatics;
    }

    public double getTotalProfitRate() {
        return totalProfitRate;
    }

    private int countMatchedNumbers(List<Integer> lottoNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winnigNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkMatchedBonusNumber() {
        return winnigNumbers.contains(BonusNumber);
    }

    private void calTotalProfitRate() {
        long totalPrizeAmount = 0L;
        for (Map.Entry<Rank, Integer> entry : lottoStatics.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            totalPrizeAmount += rank.getPrizeAmount() * count;
        }
        double profitRate = (double) totalPrizeAmount / purchaseAmount;
        totalProfitRate = (profitRate * 100.0);
    }
}