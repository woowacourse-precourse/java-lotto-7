package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoRank {

    private static final Map<PointResult, Integer> lottoRanks = new HashMap<>();
    private final Integer calculatedLottoRank;

    static {
        lottoRanks.put(new PointResult(6, 0), 1);
        lottoRanks.put(new PointResult(5, 1), 2);
        lottoRanks.put(new PointResult(5, 0), 3);
        lottoRanks.put(new PointResult(4, 0), 4);
        lottoRanks.put(new PointResult(3, 0), 5);
    }

    public LottoRank(PointResult pointResult) {
        this.calculatedLottoRank = calculateLottoRank(pointResult);
    }

    public Integer calculateLottoRank(PointResult pointResult) {
        return lottoRanks.getOrDefault(pointResult, null);
    }

    public Integer getCalculatedLottoRank() {
        return calculatedLottoRank;
    }
}
