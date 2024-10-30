package lotto.prizelotto;

import java.util.List;
import lotto.RankPrice;
import lotto.domain.WinNumbers;

public class ThirdPrizeLotto extends PrizeLotto {
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
        return 3;
    }

    @Override
    public int getCount() {
        return count;
    }
}
