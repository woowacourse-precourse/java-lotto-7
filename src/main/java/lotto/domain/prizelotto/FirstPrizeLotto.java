package lotto.domain.prizelotto;

import java.util.List;
import lotto.RankPrice;
import lotto.domain.WinNumbers;

public class FirstPrizeLotto extends PrizeLotto {

    @Override
    public int calculatePrize() {
        return RankPrice.FIRST.getPrice() * count;
    }

    @Override
    public boolean isSatisfyRule(int count, List<Integer> lottoNumbers, WinNumbers winNumbers) {
        return count == 6;
    }

    @Override
    public int getRank() {
        return 1;
    }

    @Override
    public int getCount() {
        return count;
    }
}
