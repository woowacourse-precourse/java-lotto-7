package lotto.common;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersCreator {

    public static List<Integer> create(int min, int max, int count) {
        return Randoms.pickUniqueNumbersInRange(min, max, count);
    }
}
