package lotto.model.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.model.lotto.LottoConstants.*;

public class NumbersGenerator {
    public static List<Integer> generateSortedNumbers() {
        List<Integer> uniqueNumbersInRange = new ArrayList<>(generateNumbers());
        Collections.sort(uniqueNumbersInRange);
        return uniqueNumbersInRange;
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUM_MIN, LOTTO_NUM_MAX, LOTTO_SIZE);
    }
}
