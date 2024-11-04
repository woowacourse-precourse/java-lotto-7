package lotto.utils;

import static lotto.constant.Constants.LOTTO_SIZE;
import static lotto.constant.Constants.MAX_LOTTO_NUMBER;
import static lotto.constant.Constants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class RandomNumberGenerator {

    private RandomNumberGenerator() {}

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
    }

}
