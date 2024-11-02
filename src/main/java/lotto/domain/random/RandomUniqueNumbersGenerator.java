package lotto.domain.random;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.vo.LottoNumber;
import lotto.infrastructure.constant.LottoConfig;

import java.util.List;

public class RandomUniqueNumbersGenerator implements RandomGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoNumber.MIN, LottoNumber.MAX, LottoConfig.COUNT);
    }
}
