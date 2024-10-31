package lotto.model;

import java.util.Map;

public class WinningResult {

    private final Map<Rank, Integer> result;

    public WinningResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public Integer getWinningCount(Rank rank) {
        return result.get(rank);
    }

}
