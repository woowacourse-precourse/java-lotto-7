package lotto.domain.random;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.vo.LottoNumber;

import java.util.List;

public class RandomUniqueNumbersGenerator implements RandomGenerator {
    private static final int COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoNumber.MIN, LottoNumber.MAX, COUNT);
    }
}
