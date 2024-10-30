package lotto.global.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomValue {

    public static List<Integer> generate(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
