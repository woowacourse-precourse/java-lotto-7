package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public abstract class RandomNumberGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;

    private RandomNumberGenerator() {
    }

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
    }
}
