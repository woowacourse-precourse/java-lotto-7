package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos purchase(int purchaseCount) {
        List<Lotto> purchasedLottos = IntStream.range(0, purchaseCount)
                .mapToObj(lotto -> new RandomLottoGenerator().generateLotto())
                .toList();
        return new Lottos(purchasedLottos);
    }

    public Map<LottoRank, Integer> lottoResultFrom(WinningLotto winningLotto) {
        Map<LottoRank, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : lottos) {
            long matchingCount = lotto.matchingCountWith(winningLotto.getLotto());
            boolean isBonusNumberMatch = lotto.contains(winningLotto.getBonusNumber());
            LottoRank lottoRank = LottoRank.rankFrom(matchingCount, isBonusNumberMatch);
            lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
        }
        return lottoResult;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
