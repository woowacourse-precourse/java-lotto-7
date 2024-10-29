package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoGameConfig;

import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoGameConfig.START_NUMBER,
                LottoGameConfig.END_NUMBER,
                LottoGameConfig.COUNT
        );
    }

}
