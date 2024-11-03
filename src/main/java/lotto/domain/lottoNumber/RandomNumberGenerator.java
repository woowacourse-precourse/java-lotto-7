package lotto.domain.lottoNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    private final int startInclusive = LottoRange.LOTTO.getStart();
    private final int endInclusive = LottoRange.LOTTO.getEnd();
    private final int count = LottoRange.LOTTO.getCount();

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }

}