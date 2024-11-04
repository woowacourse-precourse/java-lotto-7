package lotto.dto;

import java.util.HashMap;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoResultDTO {
    private final Map<LottoRank, Integer> lottoRankCount;
    private final double lottoProfitRate;

    private LottoResultDTO(Map<LottoRank, Integer> lottoRankCount, double lottoProfitRate) {
        this.lottoRankCount = new HashMap<>(lottoRankCount);
        this.lottoProfitRate = lottoProfitRate;
    }

    public static LottoResultDTO ofRankCountAndProfitRate(
            Map<LottoRank, Integer> lottoRankCount, double lottoProfitRate) {
        return new LottoResultDTO(lottoRankCount, lottoProfitRate);
    }

    public Map<LottoRank, Integer> getLottoRankCount() {
        return lottoRankCount;
    }

    public double getLottoProfitRate() {
        return lottoProfitRate;
    }

}
