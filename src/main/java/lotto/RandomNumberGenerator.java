package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> generate(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
