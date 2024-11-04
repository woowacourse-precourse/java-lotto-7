package lotto.core;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGenerator {
    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return LottoSorter.sort(numbers);
    }
}
