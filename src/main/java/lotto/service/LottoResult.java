package lotto.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.Rank;

public class LottoResult {

    Map<Rank, Integer> result = new LinkedHashMap<>();
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
