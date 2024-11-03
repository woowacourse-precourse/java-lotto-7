package lotto.common.util.random;

import static lotto.common.rule.Rule.LOTTO_LENGTH;
import static lotto.common.rule.Rule.LOTTO_MAXIMUM_NUMBER;
import static lotto.common.rule.Rule.LOTTO_MINIMUM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoRandomGenerator implements RandomGenerator {

    @Override
    public List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER, LOTTO_LENGTH);
    }
}
