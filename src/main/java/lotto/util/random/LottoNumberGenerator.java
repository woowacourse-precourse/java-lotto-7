package lotto.util.random;

import static lotto.constants.GlobalLottoConst.MAX_LOTTO_NUMBER;
import static lotto.constants.GlobalLottoConst.MAX_LOTTO_NUMBERS_COUNT;
import static lotto.constants.GlobalLottoConst.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, MAX_LOTTO_NUMBERS_COUNT);
    }

}
