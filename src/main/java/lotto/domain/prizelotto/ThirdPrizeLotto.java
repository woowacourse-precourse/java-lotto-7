package lotto.domain.prizelotto;

import java.util.List;
import lotto.RankPrice;
import lotto.domain.WinNumbers;

public class ThirdPrizeLotto extends PrizeLotto {

    private static final int RANK = 3;
    private static final int MATCH_COUNT = 5;
    private static final int PRICE = 1500000;

    @Override
    public int calculatePrize() {
        return RankPrice.THIRD.getPrice() * count;
    }

    @Override
    public boolean isSatisfyRule(int count, List<Integer> lottoNumbers, WinNumbers winNumbers) {
        return (count == 5) && (!lottoNumbers.contains(winNumbers.bonusWinNumber()));
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
