package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    private Map<LottoRank, Integer> rankCount = new HashMap<>();

    public LottoChecker() {
        for(LottoRank lottoRank : LottoRank.values()){
            rankCount.put(lottoRank, 0);
        }
    }

    public void checkLotto(List<Integer> winLotto, List<Lotto> issuedLottos, int bonusLotto) {
        for (Lotto issuedLotto : issuedLottos) {
            long count = winLotto.stream()
                    .filter(issuedLotto.getNumbers()::contains)
                    .count();
            int bonus = 0;
            if (issuedLotto.getNumbers().contains(bonusLotto)) {
                bonus++;
            }
            LottoRank lottoRank = getLottoRank(count, bonus);
            rankCount.put(lottoRank, rankCount.get(lottoRank) + 1);

        }
    }

    public double calculateProfit(int price){
        int profit =0 ;
        for (LottoRank lottoRank : rankCount.keySet()) {
            profit += lottoRank.getPrice() * rankCount.get(lottoRank);
        }
        double roi = 0;
        roi = profit / (double)price * 100;
        return roi;
    }

    public Map<LottoRank,Integer> getRankCount(){
        return rankCount;
    }



    private LottoRank getLottoRank(long count, long bonus) {
        if (count == 6) {
            return LottoRank.FIRST;
        }
        if ((count + bonus) == 6) {
            return LottoRank.SECOND;
        }
        if ((count + bonus) == 5) {
            return LottoRank.THIRD;
        }
        if ((count + bonus) == 4) {
            return LottoRank.FOURTH;
        }
        if ((count + bonus) == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.MISS;
    }
}
