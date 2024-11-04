package lotto.util;

import static lotto.constant.LottoInfo.END_NUMBER;
import static lotto.constant.LottoInfo.PICK_COUNT;
import static lotto.constant.LottoInfo.START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoNumbersGenerator {

    public static List<Integer> generate() {
        List<Integer> mutableNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, PICK_COUNT));
        mutableNumbers.sort(Comparator.naturalOrder());
        return mutableNumbers;
    }
}
