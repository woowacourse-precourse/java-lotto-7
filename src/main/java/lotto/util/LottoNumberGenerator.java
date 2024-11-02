package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                GeneratorConstants.LOTTO_NUMBER_MIN.getValue(),
                GeneratorConstants.LOTTO_NUMBER_MAX.getValue(),
                GeneratorConstants.LOTTO_NUMBER_COUNT.getValue()
        );
    }

}
