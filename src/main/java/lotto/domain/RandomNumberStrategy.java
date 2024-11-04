package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberStrategy implements NumberStrategy {
    public static final int MIN_BOUND = 1;
    public static final int MAX_BOUND = 45;
    public static final int COUNT_NUMBER = 6;

    @Override
    public List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_BOUND, MAX_BOUND, COUNT_NUMBER);
    }
}
