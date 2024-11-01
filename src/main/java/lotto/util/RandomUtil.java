package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomUtil {
    private RandomUtil() {
    }

    public static List<Integer> getSixRandomNumbers(Integer min, Integer max) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(min, max, 6);
        return numbers;
    }
}
