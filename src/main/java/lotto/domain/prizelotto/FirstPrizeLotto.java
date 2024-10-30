package lotto.domain.prizelotto;

import java.util.List;
import lotto.domain.WinNumbers;

public class FirstPrizeLotto extends PrizeLotto {

    private static final int RANK = 1;
    private static final int MATCH_COUNT = 6;
    private static final int PRICE = 2000000000;

    @Override
    public int calculatePrize() {
        return PRICE * count;
    }

    @Override
    public boolean isSatisfyRule(int count, List<Integer> lottoNumbers, WinNumbers winNumbers) {
        return count == 6;
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
