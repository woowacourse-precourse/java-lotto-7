package lotto.model;

import java.util.HashMap;
import java.util.Map;

public abstract class PriceData {
    protected Map<Rank, Price> prizeByRank = new HashMap<>();

    public PriceData() {
        initializePrizes();
    }

    protected abstract void initializePrizes();
}
