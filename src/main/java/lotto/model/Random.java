package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.LottoInfo;
import lotto.util.Range;

public class Random {
    public static List<Integer> pickUniqueNumbersInRange() {
        return Randoms.pickUniqueNumbersInRange(Range.MIN.getNum(), Range.MAX.getNum(), LottoInfo.NUM_COUNT.getNum());
    }
}
