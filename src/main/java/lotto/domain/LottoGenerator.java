package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class LottoGenerator {

    public static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_MIN, RANDOM_MAX, NUMBER_OF_NUMBERS);
    }
}

