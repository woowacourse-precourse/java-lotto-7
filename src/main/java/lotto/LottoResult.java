package lotto;

import constants.Constants;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoResult {
    private final Map<Integer, Integer> prizeCountMap = new HashMap<>();
    private int totalPrize = 0;

    public LottoResult(){
        for (int i =1; i<=Constants.REWARD_TYPE_COUNT; i++){
            prizeCountMap.put(i, 0);
        }
    }

    public void calculateResult(List<Lotto> lottos, Lotto mainLotto, int bonusNumber){
        for (Lotto lotto : lottos){
            int matchCount = getMatchCount(lotto, mainLotto);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            int rank = getRank(matchCount, bonusMatch);
            if (rank != 0){
                prizeCountMap.put(rank, prizeCountMap.get(rank)+1);
                totalPrize += Constants.REWARD_PRICE[rank-1];
            }
        }
    }

    private int getMatchCount(Lotto lotto, Lotto mainLotto){
        int matchCount = 0;
        for (int number : lotto.getNumbers()){
            if (mainLotto.getNumbers().contains(number)){
                matchCount++;
            }
        }
        return matchCount;
    }

    private int getRank(int matchCount, boolean bonusMatch){
        if (matchCount == 6) return 1;
        if (matchCount == 5 && bonusMatch) return 2;
        if (matchCount == 5) return 3;
        if (matchCount == 4) return 4;
        if (matchCount == 3) return 5;
        return 0;
    }

    public int getPrizeCount(int rank) {
        return prizeCountMap.getOrDefault(rank, 0);
    }

    public double calculateProfitRate(int purchaseAmount){
        double profitRate = (double)totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 100) / 100.0;
    }

}
