package lotto.domain.prize;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoPrize, Integer> lottoResult;

    public LottoResult() {
        this.lottoResult = new EnumMap<>(LottoPrize.class);
        for(LottoPrize prize : LottoPrize.values()) {
            this.lottoResult.put(prize, 0);
        }
    }

    public void addLottoResult(LottoPrize lottoPrize) {
        lottoResult.put(lottoPrize, lottoResult.get(lottoPrize) +1);
    }

    public Map<LottoPrize, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
