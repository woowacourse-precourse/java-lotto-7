package lotto.domain.lottoNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    int startInclusive = LottoRange.LOTTO.getStart();
    int endInclusive = LottoRange.LOTTO.getEnd();
    int count = LottoRange.LOTTO.getCount();

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}