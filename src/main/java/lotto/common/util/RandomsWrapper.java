package lotto.common.util;

import static lotto.common.constant.LottoConstant.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomsWrapper {
    public static List<Integer> getInt() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE.getValue(), MAX_RANGE.getValue(), LENGTH.getValue());
    }
}
