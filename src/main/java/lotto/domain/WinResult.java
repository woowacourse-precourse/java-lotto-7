package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinResult {

    private static final int MATCH_COUNT_INCREMENT = 1;
    private static final int DEFAULT_MATCH_COUNT = 0;

    private final Map<String, Integer> winResult = new HashMap<>();

    {
        for(LottoRank lottoRank : LottoRank.values()) {
            winResult.put(lottoRank.name(), DEFAULT_MATCH_COUNT);
        }
    }

    public void plusCount(String rank) {
        winResult.merge(rank, MATCH_COUNT_INCREMENT, Integer::sum);
    }

    public Map<String, Integer> getWinResult() {
        return new HashMap<>(winResult);
    }

    public static WinResult create() {
        return new WinResult();
    }
}
