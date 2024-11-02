package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;

public class LottoStrategyRandom implements LottoStrategy {
    private static final Integer start = 1;
    private static final Integer end = 45;
    private static final Integer range = 6;

    public List<Integer> createNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(start, end, range);
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }
}
