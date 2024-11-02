package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoRank {

    private static final Map<String, Integer> lottoRanks = new HashMap<>();
    private final Integer calculatedLottoRank;

    static {
        lottoRanks.put("6-0", 1);
        lottoRanks.put("5-1", 2);
        lottoRanks.put("5-0", 3);
        lottoRanks.put("4-0", 4);
        lottoRanks.put("3-0", 5);
    }

    public LottoRank(PointResult pointResult) {
        this.calculatedLottoRank = calculateLottoRank(pointResult);
    }

    public Integer calculateLottoRank(PointResult pointResult) {
        String key = pointResult.getPoint() + "-" + pointResult.getBonusPoint();
        return lottoRanks.getOrDefault(key, 0);
    }

    public Integer getCalculatedLottoRank() {
        return calculatedLottoRank;
    }
}
