package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import static lotto.util.LottoConfig.*;

public class RandomNumbers {
    public static List<Integer> getGenerateLotto() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN.getNumber(), LOTTO_MAX.getNumber(), LOTTO_LENGTH.getNumber());
    }
}