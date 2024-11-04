package lotto.domain;

import lotto.view.OutputView;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoGroup {
    private final List<Lotto> lottos;

    public LottoGroup(List<Lotto> lottos){
        this.lottos=lottos;
    }

    public void printEachInfo() {
        OutputView.printLottoSize(lottos.size());
        lottos.stream().forEach(lotto-> OutputView.printLottosInfo(lotto.getNumbers()));
    }

    public Map<Rank, Integer> getEachLottoPrize(List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> prizeResult=new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values()).forEach(rank -> prizeResult.put(rank, 0));

        for (Lotto lotto:lottos){
            int hits = lotto.findHits(winningNumbers);
            BonusExistence bonusExistence = lotto.findBonus(hits, bonusNumber);

            Rank rank = Rank.of(hits, bonusExistence);
            prizeResult.put(rank, prizeResult.getOrDefault(rank, 0) + 1);
        }
        return prizeResult;
    }
}
