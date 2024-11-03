package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator implements RandomGenerator {
    public int pickNumberInRange(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }

    public List<Integer> pickUniqueNumbersInRange(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
