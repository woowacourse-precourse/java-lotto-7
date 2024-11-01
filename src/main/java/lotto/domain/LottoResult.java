package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    Map<Rank, Integer> result = new HashMap<>();
    Rank winner;

    public LottoResult(Rank rank) {
        for (Rank values : Rank.values()) {
            result.put(values, 0);
        }
        result.put(rank, 1);
        winner = rank;
    }
    
    public Map<Rank, Integer> getResult() {
        return result;
    }

    public Rank getWinner() {
        return winner;
    }
}
