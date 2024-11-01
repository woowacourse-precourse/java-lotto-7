package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constants.ModelContstants.*;

public class LottoNumberGenerator {
    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_STARTING_RANGE.getValue(),
                LOTTO_END_RANGE.getValue(),
                LOTTO_COUNT.getValue()
        );
    }
}
