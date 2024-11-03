package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PrizeMachine {
    private final List<Lotto> lottos;
    private Map<Rank,Integer> prizeResult;

    public PrizeMachine(List<Lotto> lottos) {
        this.lottos = lottos;

        prizeResult=new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values()).forEach(rank->prizeResult.put(rank,0));
    }

    public Map<Rank,Integer> getAmountOfPrize(DrawNumbers drawNumbers){
        for (Lotto lotto:lottos){
            int hits=lotto.findHits(drawNumbers.getWinningNumbers());
            BonusExistence bonusExistence =lotto.findBonus(hits, drawNumbers.getBonusNumber());

            Rank rank=Rank.of(hits, bonusExistence);
            prizeResult.put(rank,prizeResult.getOrDefault(rank,0)+1);

        }
        return prizeResult;
    }


}
