package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constants;

import java.util.List;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {}

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                Constants.MIN_LOTTO_NUMBER,
                Constants.MAX_LOTTO_NUMBER,
                Constants.LOTTO_SIZE);
    }
}
