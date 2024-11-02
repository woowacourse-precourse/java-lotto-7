package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import lotto.model.lottowinningstrategy.WinningStrategy;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
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

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        for (Lotto lotto : lottos) {
            sj.add(lotto.toString());
        }
        return sj.toString();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
