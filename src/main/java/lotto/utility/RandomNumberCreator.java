package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.Constants;

import java.util.List;

public class RandomNumberCreator {
    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER,
                Constants.MAX_LOTTO_NUMBER, Constants.REQUIRED_LOTTO_LENGTH);
    }
}
