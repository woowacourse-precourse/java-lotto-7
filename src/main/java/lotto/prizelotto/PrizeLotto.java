package lotto.prizelotto;

import java.util.List;
import lotto.domain.WinNumbers;

public abstract class PrizeLotto {

    int count;

    public void upCount() {
        count++;
    }

    abstract public int calculatePrize();

    abstract public boolean isSatisfyRule(int count, List<Integer> lottoNumbers, WinNumbers winNumbers);
}
