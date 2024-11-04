package lotto.Service;

import lotto.Lotto;
import lotto.LottoResult;
import lotto.Pair;

import java.util.ArrayList;
import java.util.List;

public class WinningService {
    public WinningService() {}

    public int[] getResult(List<Lotto> lottos, List<Integer> winnings, int bonus) {
        List<LottoResult> results = getResultbyEnum(lottos, winnings, bonus);
        int[] result = new int[5];
        for(int i = 0; i < results.size(); i++){
            if(results.get(i).ordinal() <= 4)
                result[results.get(i).ordinal()]++;
        }
        return result;
    }

    public List<LottoResult> getResultbyEnum(List<Lotto> lottos, List<Integer> winnings, int bonus) {
        List<LottoResult> results = new ArrayList<>();
        for(int i = 0; i < lottos.size(); i++) {
            LottoResult lottoRank = getContains(lottos.get(i), winnings, bonus);
            results.add(lottoRank);
        }
        return results;
    }

    private LottoResult getContains(Lotto lotto, List<Integer> winnings, int bonus) {
        int winningCount = lotto.containCount(winnings);
        boolean bonusCount = lotto.containBonus(bonus);
        Pair countPair = new Pair(bonusCount, winningCount);
        return getRank(countPair);
    }

    private LottoResult getRank(Pair countPair) {
        if((int)countPair.getValue() == 3) return LottoResult.FIVE;
        if((int)countPair.getValue() == 4) return LottoResult.FOUR;
        if((int)countPair.getValue() == 5 && !countPair.getBoolean()) return LottoResult.THREE;
        if((int)countPair.getValue() == 5 && countPair.getBoolean()) return LottoResult.TWO;
        if((int)countPair.getValue() == 6) return LottoResult.ONE;
        return LottoResult.NONE;
    }

    public double getReturnRate(int[] result, int count) {
        double earn = 0;
        earn += result[0]*2000000000;
        earn += result[1]*30000000;
        earn += result[2]*1500000;
        earn += result[3]*50000;
        earn += result[4]*5000;
        earn = Math.round((earn / 8000) * 1000)/10.0;
        return earn;
    }
}
