package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constant.NumberConstant.*;

public class NumberGenerator {

    public List<Integer> pickNumInRange() {
        return Randoms
                .pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_START,
                        LOTTO_NUMBER_RANGE_END,
                        LOTTO_NUMBER_PICK_COUNT);
    }
}
