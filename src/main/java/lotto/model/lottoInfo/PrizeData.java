package lotto.model.lottoInfo;

import java.util.HashMap;
import java.util.Map;
import lotto.model.enums.Prize;
import lotto.model.enums.Rank;

public abstract class PrizeData {
    protected Map<Rank, Prize> prizeByRank = new HashMap<>();

    public PrizeData() {
        initializePrizes();
    }

    public Prize getByRank(Rank rank) {
        return prizeByRank.get(rank);
    }

    protected abstract void initializePrizes();
}
