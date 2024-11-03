package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator{

    @Override
    public List<Integer> generateUniqueNumbersInRange(int startInclusive, int endInclusive, int numberCount) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, numberCount);
    }

}