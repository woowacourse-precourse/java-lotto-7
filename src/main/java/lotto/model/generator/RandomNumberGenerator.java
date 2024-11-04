package lotto.model.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.common.Rule.MAXIMUM_RANGE_NUMBER;
import static lotto.common.Rule.MINIMUM_RANGE_NUMBER;
import static lotto.common.Rule.NUMBER_COUNT;

public class RandomNumberGenerator implements NumberGenerator {

    public List<Integer> generate() {
        List<Integer> randomNumbers =
                Randoms.pickUniqueNumbersInRange(
                        MINIMUM_RANGE_NUMBER.getNumber(),
                        MAXIMUM_RANGE_NUMBER.getNumber(),
                        NUMBER_COUNT.getNumber()
                );
        return randomNumbers;
    }
}
