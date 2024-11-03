package lotto.util;

import static lotto.constant.LottoConstant.END_INDEX;
import static lotto.constant.LottoConstant.PICK_COUNT;
import static lotto.constant.LottoConstant.START_INDEX;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoRandomUtil {
    public static List<Integer> chooseRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(START_INDEX, END_INDEX, PICK_COUNT);
    }
}
