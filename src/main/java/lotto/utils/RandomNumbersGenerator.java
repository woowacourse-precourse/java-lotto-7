package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator {

    private RandomNumbersGenerator() {

    }

    public static List<Integer> getNumbers(int min, int max, int count) {
        return Randoms.pickUniqueNumbersInRange(min, max, count);
    }
}
