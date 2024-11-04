package lotto.domain;

import static lotto.util.Constants.LOTTO_MAX_NUMBER;
import static lotto.util.Constants.LOTTO_MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {
    private static final int NUMBER_COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, NUMBER_COUNT);
    }
}
