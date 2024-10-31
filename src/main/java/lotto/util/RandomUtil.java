package lotto.util;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static List<Integer> getLottoNumbers(int count) {
        return Randoms.pickUniqueNumbersInRange(1, 45, count);
    }
}
