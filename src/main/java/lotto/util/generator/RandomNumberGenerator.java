package lotto.util.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateUniqueNumbersInRange(
            int startInclusive,
            int endInclusive,
            int count
    ) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }

}
