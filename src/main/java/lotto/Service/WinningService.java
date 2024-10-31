package lotto.Service;

import lotto.Lotto;
import lotto.Pair;

import java.util.ArrayList;
import java.util.List;

public class WinningService {
    public WinningService() {}

    public int[] getResult(List<Lotto> lottos, List<Integer> winnings, int bonus) {
        int[] result = new int[5];
        for(int i = 0; i < lottos.size(); i++) {
            int lottoRank = getContains(lottos.get(i), winnings, bonus);
            if(lottoRank >= 0) {
                result[4 - lottoRank]++;
            }
        }
        return result;
    }

    private int getContains(Lotto lotto, List<Integer> winnings, int bonus) {
        int winningCount = lotto.containCount(winnings);
        boolean bonusCount = lotto.containBonus(bonus);
        Pair countPair = new Pair(bonusCount, winningCount);
        return getRank(countPair);
    }

    private int getRank(Pair countPair) {
        if((int)countPair.getValue() < 5) {
            return (int)countPair.getValue() - 3;
        }
        if((int)countPair.getValue() == 5 && !countPair.getBoolean()) {
            return 2;
        }
        if((int)countPair.getValue() == 5 && countPair.getBoolean()) {
            return 3;
        }
        if((int)countPair.getValue() == 6) {
            return 4;
        }
        return -1;
    }
}
