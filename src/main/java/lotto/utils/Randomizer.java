package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Randomizer {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int SIZE = 6;

    public static List<Integer> getRandomValues() {
        List<Integer> randomValues = Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, SIZE);
        return randomValues.stream().sorted().toList();
    }
}
