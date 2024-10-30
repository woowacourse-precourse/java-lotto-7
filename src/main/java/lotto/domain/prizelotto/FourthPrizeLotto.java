package lotto.domain.prizelotto;

import java.util.List;
import lotto.RankPrice;
import lotto.domain.WinNumbers;

public class FourthPrizeLotto extends PrizeLotto {

    private static final int RANK = 4;
    private static final int MATCH_COUNT = 4;
    private static final int PRICE = 50000;

    @Override
    public int calculatePrize() {
        return RankPrice.FOURTH.getPrice() * count;
    }

    @Override
    public boolean isSatisfyRule(int count, List<Integer> lottoNumbers, WinNumbers winNumbers) {
        return count == 4;
    }

    @Override
    public int getRank() {
        return RANK;
    }

    @Override
    public int getMatchCount() {
        return MATCH_COUNT;
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public int getCount() {
        return count;
    }
}
