package lotto.model.lottoInfo;

import lotto.model.enums.Prize;
import lotto.model.enums.Rank;

public class PrizeDataImpl extends PrizeData {
    @Override
    protected void initializePrizes() {
        prizeByRank.put(Rank.FIRST, Prize.FIRST_PRICE);
        prizeByRank.put(Rank.SECOND, Prize.SECOND_PRICE);
        prizeByRank.put(Rank.THIRD, Prize.THIRD_PRICE);
        prizeByRank.put(Rank.FOURTH, Prize.FOURTH_PRICE);
        prizeByRank.put(Rank.FIFTH, Prize.FIFTH_PRICE);
    }
}
