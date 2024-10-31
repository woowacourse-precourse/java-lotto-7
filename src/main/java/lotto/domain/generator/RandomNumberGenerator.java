package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.common.Lotto.*;

public class RandomNumberGenerator {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE);
    }
}
