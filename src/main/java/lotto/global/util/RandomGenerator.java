package lotto.global.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomGenerator {
    private static final Integer FIRST_NUMBER = 1;
    private static final Integer LAST_NUMBER = 45;
    private static final Integer COUNT = 6;
    private static RandomGenerator instance;

    public static RandomGenerator getInstance() {
        if (instance == null) {
            instance = new RandomGenerator();
        }
        return instance;
    }

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(FIRST_NUMBER, LAST_NUMBER, COUNT);
    }
}
