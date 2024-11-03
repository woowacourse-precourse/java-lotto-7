package lotto.model;

import lotto.Lotto;
import lotto.prize.Prize;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;



public class CalculatePrize {
    private final Lotto prize;
    private final int bonus;

    public CalculatePrize(Lotto prize, int bonus){
        this.prize = prize;
        this.bonus = bonus;
    }
    public Prize countMatch(Lotto lotto){
        List<Integer> matchNum = new ArrayList<>(lotto.getNumbers());
        List<Integer> prizeNum = new ArrayList<>(prize.getNumbers());
        boolean matchBonus = matchNum.contains(bonus);
        matchNum.retainAll(prizeNum);
        return Prize.calculatePrize(matchNum.size(), matchBonus);
    }
    public Map<Prize, Integer> countAllMatches(List<Lotto> lottos) {
        Map<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);

        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }

        for (Lotto lotto : lottos) {
            Prize prize = countMatch(lotto);
            prizeCount.put(prize, prizeCount.get(prize) + 1);
        }

        return prizeCount;
    }
}
