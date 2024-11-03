package lotto.model.lottoInfo;

import lotto.model.enums.Price;
import lotto.model.enums.Rank;

public class PriceDataImpl extends PriceData {
    @Override
    protected void initializePrizes() {
        prizeByRank.put(Rank.FIRST, Price.FIRST_PRICE);
        prizeByRank.put(Rank.SECOND, Price.SECOND_PRICE);
        prizeByRank.put(Rank.THIRD, Price.THIRD_PRICE);
        prizeByRank.put(Rank.FOURTH, Price.FOURTH_PRICE);
        prizeByRank.put(Rank.FIFTH, Price.FIFTH_PRICE);
    }
}
