package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.util.NumbersGenerator;

public class Lottos {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos purchase(int purchaseCount, NumbersGenerator numbersGenerator) {
        List<Lotto> purchasedLottos = IntStream.range(0, purchaseCount)
                .mapToObj(lotto -> Lotto.of(
                        numbersGenerator.generateNumbers(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT)))
                .toList();
        return new Lottos(purchasedLottos);
    }

    public Map<LottoRank, Integer> lottoResultFrom(WinningLotto winningLotto) {
        Map<LottoRank, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : lottos) {
            long matchingCount = lotto.matchingCountWith(winningLotto.getLotto());
            boolean isBonusNumberMatch = lotto.contains(winningLotto.getBonusNumber());
            LottoRank lottoRank = LottoRank.rankFrom(matchingCount, isBonusNumberMatch);
            lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + MIN_LOTTO_NUMBER);
        }
        return lottoResult;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
