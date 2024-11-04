package lotto.domain;

import static lotto.constants.LotteryConstant.LOTTO_NUMBERS_COUNT;
import static lotto.constants.LotteryConstant.MAX_NUMBER;
import static lotto.constants.LotteryConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LotteryNumberGenerator {
    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(),
                LOTTO_NUMBERS_COUNT.getValue());
    }
}
