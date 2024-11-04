package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> store;
    private int totalPrize = 0;

    public LottoResult() {
        this.store = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            store.put(rank, 0);
        }
    }

    public void save(Rank rank) {
        store.put(rank, store.get(rank) + 1);
        totalPrize += rank.getPrize();
    }

    public Map<Rank, Integer> getLottoResult() {
        return store;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
