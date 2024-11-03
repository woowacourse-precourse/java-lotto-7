package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.ErrorMessage;
import lotto.common.LottoConstants;

public final class RandomNumberUtil {

    private RandomNumberUtil() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS_INSTANTIATION.getMessage());
    }

    public static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_MIN_NUMBER, LottoConstants.LOTTO_MAX_NUMBER, LottoConstants.LOTTO_NUMBER_COUNT);
    }
}

