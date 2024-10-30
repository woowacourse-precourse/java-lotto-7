package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoFactoryImpl implements LottoFactory {

    @Override
    public Lotto create(int startInclusive, int endInclusive, int count) {
        List<Integer> lottoCombination = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
        return new Lotto(lottoCombination);
    }
}
