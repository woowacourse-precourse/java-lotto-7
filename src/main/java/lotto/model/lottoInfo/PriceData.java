package lotto.model.lottoInfo;

import java.util.HashMap;
import java.util.Map;
import lotto.model.enums.Price;
import lotto.model.enums.Rank;

public abstract class PriceData {
    protected Map<Rank, Price> prizeByRank = new HashMap<>();

    public PriceData() {
        initializePrizes();
    }

    protected abstract void initializePrizes();
}
