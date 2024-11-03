package lotto.domain.prizelotto;

import java.util.List;
import lotto.domain.WinNumbers;

public abstract class PrizeLotto {

    int count;

    public void upCount() {
        count++;
    }

    abstract public int calculatePrize();

    abstract public boolean isSatisfyPrizeRule(int count, List<Integer> lottoNumbers, WinNumbers winNumbers);

    abstract public int getRank();

    abstract public int getCount();

    abstract public int getMatchCount();

    abstract public int getPrice();
}
