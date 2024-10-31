package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoReward, Integer> lottoResult;

    public LottoResult(List<LottoReward> lottoRewards) {
        lottoResult = new EnumMap<>(LottoReward.class);
        for (LottoReward lottoReward : LottoReward.values()) {
            lottoResult.put(lottoReward, Collections.frequency(lottoRewards, lottoReward));
        }
    }

    public Map<LottoReward, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
