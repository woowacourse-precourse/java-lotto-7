package lotto.domain.utility.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomIntegerListGenerator implements RandomNumberListGenerator<Integer> {
    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {

        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
