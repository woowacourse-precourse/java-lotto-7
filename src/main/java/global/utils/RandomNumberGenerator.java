package global.utils;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    protected List<Integer> generateUniqueRandomNumbers(int min, int max, int count) {
        return Randoms.pickUniqueNumbersInRange(min, max, count);
    }
}