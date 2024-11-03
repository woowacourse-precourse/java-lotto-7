package lotto.helper.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUtil {
    public static List<Integer> generateRandomNumbers(int startNumber, int endNumber, int countNumber) {
        return Randoms.pickUniqueNumbersInRange(startNumber, endNumber, countNumber);
    }
}
