package lotto.util.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {

    private RandomNumberGenerator(){}

    public static List<Integer> generateUniqueRandomNumbers(int min, int max, int count) {
        return Randoms.pickUniqueNumbersInRange(min, max, count);
    }
}
