package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> getNumber(int min, int max, int size) {
        return Randoms.pickUniqueNumbersInRange(min, max, size);
    }
}
