package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumber {

    private static final int numbersPerSet = 6;

    public List<Integer> getUniqueRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, numbersPerSet);
    }
}
