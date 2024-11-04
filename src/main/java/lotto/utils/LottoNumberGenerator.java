package lotto.utils;

import static lotto.constants.LottoConstant.END_NUMBER;
import static lotto.constants.LottoConstant.PICK_COUNT;
import static lotto.constants.LottoConstant.START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, PICK_COUNT));
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
