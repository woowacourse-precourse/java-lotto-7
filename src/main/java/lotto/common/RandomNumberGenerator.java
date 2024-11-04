package lotto.common;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {
    public List<Integer> generateUniqueRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(LottoConfig.LOTTO_MIN_NUMBER.getValue(),
                LottoConfig.LOTTO_MAX_NUMBER.getValue(), LottoConfig.LOTTO_PICK_COUNT.getValue());
    }
}
