package lotto.domain.util;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.Winning;

public class CreateWinningMap {

    private static final int DEFAULT_COUNT = 0;

    private CreateWinningMap(){}

    public static Map<String, Integer> create() {
        Map<String, Integer> winningDetail = new LinkedHashMap<>();
        Winning[] winnings = Winning.values();
        for (Winning winning : winnings) {
            winningDetail.put(winning.getMean(), DEFAULT_COUNT);
        }
        return winningDetail;
    }
}
