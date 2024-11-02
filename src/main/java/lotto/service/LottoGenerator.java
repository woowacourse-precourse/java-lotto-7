package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoInfo;

public class LottoGenerator {
    public Lotto generate() {
        List<Integer> randomNums = Randoms.pickUniqueNumbersInRange(LottoInfo.MIN_NUM_RANGE, LottoInfo.MAX_NUM_RANGE,
                LottoInfo.NUM_SIZE);
        return new Lotto(randomNums);
    }
}
