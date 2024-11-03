package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.ErrorMessage;
import lotto.common.LottoConstants;

public final class RandomNumberUtil {

    private RandomNumberUtil() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS_INSTANTIATION.getMessage());
    }

    public static int generateLottoNumber() {
        return Randoms.pickNumberInRange(LottoConstants.LOTTO_MIN_NUMBER, LottoConstants.LOTTO_MAX_NUMBER);
    }
}

