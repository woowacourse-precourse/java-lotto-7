package lotto.domain.prizelotto;

import java.util.List;
import lotto.domain.WinNumbers;

public class SecondPrizeLotto extends PrizeLotto {

    private static final int RANK = 2;
    private static final int MATCH_COUNT = 5;
    private static final int PRICE = 30000000;

    @Override
    public int calculatePrize() {
        return PRICE * count;
    }

    @Override
    public boolean isSatisfyPrizeRule(int count, List<Integer> lottoNumbers, WinNumbers winNumbers) {
        return (count == MATCH_COUNT) && (lottoNumbers.contains(winNumbers.bonusWinNumber()));
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
