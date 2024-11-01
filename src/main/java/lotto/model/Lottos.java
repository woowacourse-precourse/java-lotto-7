package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.lottowinningstrategy.WinningStrategy;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Map<LottoRank, Integer> calculateLottoRanks(WinningStrategy winningStrategy, WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> lottoRanks = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = winningStrategy.calculateRank(lotto, winningNumbers);
            insertLottoRanks(lottoRanks, lottoRank);
        }
        return lottoRanks;
    }

    private void insertLottoRanks(Map<LottoRank, Integer> lottoRanks, LottoRank lottoRank) {
        lottoRanks.put(lottoRank, lottoRanks.getOrDefault(lottoRank, 0) + 1);
    }
}
