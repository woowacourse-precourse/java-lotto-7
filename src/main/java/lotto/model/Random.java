package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import lotto.util.LottoInfo;
import lotto.util.Range;

public class Random {
    public static List<Integer> pickUniqueNumbersInRange() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Range.MIN.getNum(), Range.MAX.getNum(), LottoInfo.NUMBER_COUNT.getNum());
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
