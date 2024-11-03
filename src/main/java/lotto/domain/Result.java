package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> winningLottos;

    public Result() {
        winningLottos = new HashMap<>();
        for (Rank rank : Rank.values()) {
            winningLottos.put(rank, 0);
        }
    }

    public void increaseWinningResult(Rank rank) {
        winningLottos.put(rank, winningLottos.get(rank) + 1);
    }

    public int getWinningCount(Rank rank) {
        return winningLottos.get(rank);
    }
}
