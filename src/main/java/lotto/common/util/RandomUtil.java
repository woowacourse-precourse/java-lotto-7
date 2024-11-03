package lotto.common.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUtil {

    public static List<Integer> pickUniqueNumbersInRange(int min, int max, int size) {
        return Randoms.pickUniqueNumbersInRange(min, max, size);
    }

}
