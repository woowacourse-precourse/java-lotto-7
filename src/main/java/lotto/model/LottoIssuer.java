package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.Constants;

public class LottoIssuer {
    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_NUMBER_RANGE_START,
                Constants.LOTTO_NUMBER_RANGE_END,
                Constants.LOTTO_NUMBER_LENGTH);
        return new Lotto(numbers);
    }
}
