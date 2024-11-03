package lotto.model.number_generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {

    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
