package lotto.run;

import java.util.List;
import java.util.Map;

public class ResultLotto {
    private static Map<Prize, Integer> lottoState;
    private static double totalProfitRate;
    private final long purchasePrice;
    private final List<Lotto> lottos;
    private final List<Integer> winNums;
    private final int bonusNum;

    public ResultLotto(long purchasePrice, List<Lotto> lottos, List<Integer> winNums, int bonusNum) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
        this.winNums = winNums;
        this.bonusNum = bonusNum;
    }

    public void calResult() {
        lottoState = Prize.getPrizeCount();
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCnt = countMatchNum(lottoNumbers);
            boolean isBonusMatch = checkMatchBonusNum();
            Prize prize = Prize.getPrize(matchCnt, isBonusMatch);
            int cnt = lottoState.getOrDefault(prize, 0);
            lottoState.put(prize, cnt + 1);
        }
        calTotalPrizeRate();
    }

    public Map<Prize, Integer> getLottoState() {
        return lottoState;
    }

    public double getTotalProfitRate() {
        return totalProfitRate;
    }

    private int countMatchNum(List<Integer> lottoNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winNums.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkMatchBonusNum() {
        return winNums.contains(bonusNum);
    }

    private void calTotalPrizeRate() {
        long totalPrize = 0L;
        for (Map.Entry<Prize, Integer> entry : lottoState.entrySet()) {
            Prize prize = entry.getKey();
            Integer count = entry.getValue();
            totalPrize += prize.getPrizeNum() * count;
        }
        double prizeRate = (double) totalPrize / purchasePrice;
        totalProfitRate = (prizeRate * 100.0);
    }
}