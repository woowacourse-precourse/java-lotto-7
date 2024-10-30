package lotto.domain.prizelotto;

import java.util.List;
import lotto.RankPrice;
import lotto.domain.WinNumbers;

public class FifthPrizeLotto extends PrizeLotto {
    @Override
    public int calculatePrize() {
        return RankPrice.FIFTH.getPrice() * count;
    }

    @Override
    public boolean isSatisfyRule(int count, List<Integer> lottoNumbers, WinNumbers winNumbers) {
        return count == 3;
    }

    @Override
    public int getRank() {
        return 5;
    }

    @Override
    public int getCount() {
        return count;
    }
}
