package lotto.lotto.providable;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUniqueNumbersProvider implements NumbersProvidable {
    public static final int MINIMUM_LOTTO_VALUE = 1;
    public static final int MAXIMUM_LOTTO_VALUE = 45;
    public static final int NUM_OF_LOTTO_NUMBERS = 6;

    @Override
    public List<Integer> provide() {
        return Randoms.pickUniqueNumbersInRange(
                MINIMUM_LOTTO_VALUE,
                MAXIMUM_LOTTO_VALUE,
                NUM_OF_LOTTO_NUMBERS
        );
    }
}
