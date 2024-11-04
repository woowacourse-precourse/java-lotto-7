package lotto.input.producer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumbersProducer {
    public static List<Integer> getUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
