package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<LottoRank, Integer> getLottoResults(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<LottoRank> ranks = getLottoRanks(winningNumbers, bonusNumber);
        return countLottoRanks(ranks);
    }

    private Map<LottoRank, Integer> countLottoRanks(List<LottoRank> ranks) {
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
        for (LottoRank lottoRank : ranks) {
            result.put(lottoRank, result.get(lottoRank) + 1);
        }
        return result;
    }

    private List<LottoRank> getLottoRanks(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.calculateRank(winningNumbers, bonusNumber))
                .toList();
    }
}
