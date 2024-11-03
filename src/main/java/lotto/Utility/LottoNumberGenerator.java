package lotto.Utility;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LIST_NUMBER = 6;

    public static List<Integer> generateLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LIST_NUMBER);
        Collections.sort(randomNumbers);
        return randomNumbers;

    }

}
