package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator {
    public static List<Integer> getNumbers(int max, int min, int count) {
        return Randoms.pickUniqueNumbersInRange(max, min, count);
    }
}
