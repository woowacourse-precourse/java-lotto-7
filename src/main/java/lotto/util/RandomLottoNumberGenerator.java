package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.enums.LottoInfo;

public class RandomLottoNumberGenerator {
    private static final int PICK_COUNT = LottoInfo.LOTTO_SIZE.getValue();
    private static final int MIN_LIMIT = LottoInfo.LOTTO_MIN_LIMIT.getValue();
    private static final int MAX_LIMIT = LottoInfo.LOTTO_MAX_LIMIT.getValue();

    public static List<Integer> pickUnique6Numbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LIMIT, MAX_LIMIT, PICK_COUNT);
    }
}
