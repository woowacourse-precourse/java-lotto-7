package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.LottoConstants;
import lotto.util.NumbersGenerator;

public class PurchasedLottos {

    private final List<Lotto> lottos;

    private PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static PurchasedLottos purchase(int purchaseCount, NumbersGenerator numbersGenerator) {
        List<Lotto> purchasedLottos = IntStream.range(0, purchaseCount)
                .mapToObj(lotto -> Lotto.of(
                        numbersGenerator.generateNumbers(LottoConstants.MIN_LOTTO_NUMBER.getValue(),
                                LottoConstants.MAX_LOTTO_NUMBER.getValue(), LottoConstants.LOTTO_COUNT.getValue())))
                .toList();
        return new PurchasedLottos(purchasedLottos);
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
