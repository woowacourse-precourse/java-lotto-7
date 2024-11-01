package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.LottoInfo;
import lotto.util.Range;

public class Random {
    public List<Integer> pickUniqueNumbersInRange() {
        return Randoms.pickUniqueNumbersInRange(Range.MIN.getNum(), Range.MAX.getNum(), LottoInfo.NUM_COUNT.getNum());
    }

    public int pickNumberInRange() {
        return Randoms.pickNumberInRange(Range.MIN.getNum(), Range.MAX.getNum());
    }
}
