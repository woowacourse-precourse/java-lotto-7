package lotto.utilities;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Random {
    private static final int MINIMUM_RANDOM_NUMBER = 1;
    private static final int MAXIMUM_RANDOM_NUMBER = 45;
    private static final int QUANTITY_OF_NUMBERS = 6;

    public static List<Integer> lottoGenerator() {
        List<Integer> randomNumber =
            Randoms.pickUniqueNumbersInRange(
                MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER, QUANTITY_OF_NUMBERS);
        return randomNumber;
    }
}
