package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> winningLottos;

    public Result() {
        winningLottos = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            winningLottos.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getWinningLottos() {
        return winningLottos;
    }

    public void increaseWinningResult(Rank rank) {
        winningLottos.put(rank, winningLottos.get(rank) + 1);
    }

    public long getWinningCount(Rank rank) {
        return winningLottos.get(rank);
    }

    public Prize getTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : winningLottos.entrySet()) {
            long prize = entry.getKey().getPrize();
            int numberOfPrize = entry.getValue();

            totalPrize += prize * numberOfPrize;
        }

        return new Prize(totalPrize);
    }
}
