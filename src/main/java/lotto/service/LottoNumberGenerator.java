package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstants;

public class LottoNumberGenerator {

    public List<Integer> generate() {
        return new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        LottoConstants.LOTTO_NUMBER_MIN,
                        LottoConstants.LOTTO_NUMBER_MAX,
                        LottoConstants.LOTTO_NUMBER_COUNT
                ));
    }
}
