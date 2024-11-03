package lotto.model.lotto;

import static lotto.model.lotto.LottoConstants.END_INCLUSIVE;
import static lotto.model.lotto.LottoConstants.START_INCLUSIVE;
import static lotto.model.lotto.LottoConstants.VALID_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, VALID_SIZE);
    }
}
