package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoRandomUtil {
    private static final Integer START_INDEX = 1;
    private static final Integer END_INDEX = 45;
    private static final Integer PICK_COUNT = 6;

    public static List<Integer> chooseRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(START_INDEX, END_INDEX, PICK_COUNT);
    }
}
