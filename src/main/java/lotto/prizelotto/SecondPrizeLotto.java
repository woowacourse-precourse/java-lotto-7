package lotto.prizelotto;

import java.util.List;
import lotto.RankPrice;
import lotto.domain.WinNumbers;

public class SecondPrizeLotto extends PrizeLotto {
    @Override
    public int calculatePrize() {
        return RankPrice.SECOND.getPrice() * count;
    }

    @Override
    public boolean isSatisfyRule(int count, List<Integer> lottoNumbers, WinNumbers winNumbers) {
        return (count == 5) && (lottoNumbers.contains(winNumbers.bonusWinNumber()));
    }

    @Override
    public int getRank() {
        return 2;
    }

    @Override
    public int getCount() {
        return count;
    }
}
