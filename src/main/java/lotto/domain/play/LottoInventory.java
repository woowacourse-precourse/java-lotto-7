package lotto.domain.play;

import lotto.domain.rule.PrizeRank;
import lotto.domain.ticket.Lotto;

import java.util.List;
import java.util.Map;
import java.util.EnumMap;
import java.util.Arrays;

public class LottoInventory {
    private final List<Lotto> lottos;

    public LottoInventory(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Result calculateResult(WinCriteria winCriteria) {
        Map<PrizeRank, Integer> prizeRanks = initPrizeRanks();
        lottos.stream()
                .map(winCriteria::findPrize)
                .forEach(prizeRank -> addCount(prizeRank, prizeRanks));
        return new Result(prizeRanks);
    }

    private Map<PrizeRank, Integer> initPrizeRanks() {
        Map<PrizeRank, Integer> prizeRanks = new EnumMap<>(PrizeRank.class);
        Arrays.stream(PrizeRank.values())
                .forEach(prizeRank -> prizeRanks.put(prizeRank, 0));
        return prizeRanks;
    }

    private void addCount(PrizeRank prizeRank, Map<PrizeRank, Integer> prizeRanks) {
        prizeRanks.compute(prizeRank, (key, val) -> val + 1);
    }

    public List<Lotto> getAll() {
        return List.copyOf(lottos);
    }
}
