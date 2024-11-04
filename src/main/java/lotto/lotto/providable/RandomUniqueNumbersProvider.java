package lotto.lotto.providable;

import static lotto.lotto.constant.LottoConstant.MAXIMUM_LOTTO_VALUE;
import static lotto.lotto.constant.LottoConstant.MINIMUM_LOTTO_VALUE;
import static lotto.lotto.constant.LottoConstant.NUM_OF_LOTTO_NUMBERS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUniqueNumbersProvider implements NumbersProvidable {

    @Override
    public List<Integer> provide() {
        return Randoms.pickUniqueNumbersInRange(
                MINIMUM_LOTTO_VALUE,
                MAXIMUM_LOTTO_VALUE,
                NUM_OF_LOTTO_NUMBERS
        );
    }
}
