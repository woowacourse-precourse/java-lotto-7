package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumbersGenerator {
    public static List<Integer> create() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
