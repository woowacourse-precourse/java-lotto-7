package lotto.prizelotto;

import java.util.List;
import lotto.RankPrice;
import lotto.domain.WinNumbers;

public class FourthPrizeLotto extends PrizeLotto {
    @Override
    public int calculatePrize() {
        return RankPrice.FOURTH.getPrice() * count;
    }

    @Override
    public boolean isSatisfyRule(int count, List<Integer> lottoNumbers, WinNumbers winNumbers) {
        return count == 4;
    }
}
