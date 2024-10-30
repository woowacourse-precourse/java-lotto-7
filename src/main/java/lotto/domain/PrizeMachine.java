package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PrizeMachine {
    private final List<Lotto> lottos;
    private Map<Rank,Integer> prizeResult;

    public PrizeMachine(List<Lotto> lottos) {
        this.lottos = lottos;
        prizeResult=new EnumMap<>(Rank.class);

        prizeResult.put(Rank.UNDER_TWO_HIT,0);
        prizeResult.put(Rank.THREE_HIT,0);
        prizeResult.put(Rank.FOUR_HIT,0);
        prizeResult.put(Rank.FIVE_HIT_WITHOUT_BONUS,0);
        prizeResult.put(Rank.FIVE_HIT_WITH_BONUS,0);
        prizeResult.put(Rank.SIX_HIT,0);
    }

    public Map<Rank,Integer> getAmountOfPrize(List<Integer> winningNumbers, int bonusNumber){
        for (Lotto lotto:lottos){
            int hits=lotto.findHits(winningNumbers, bonusNumber);
            BonusExistence bonusExistence =lotto.findBonus(hits,bonusNumber);

            Rank rank=Rank.of(hits, bonusExistence);
            prizeResult.put(rank,prizeResult.getOrDefault(rank,0)+1);

        }
        return prizeResult;
    }


}
