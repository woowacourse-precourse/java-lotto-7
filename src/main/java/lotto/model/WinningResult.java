package lotto.model;

import java.util.Map;

public class WinningResult {

    private final Map<Rank, Integer> result;

    public WinningResult(Map<Rank, Integer> result) {
        this.result = result;
    }

}
