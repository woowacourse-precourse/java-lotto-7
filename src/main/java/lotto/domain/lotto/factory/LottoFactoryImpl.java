package lotto.domain.lotto.factory;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;

import java.util.List;

public class LottoFactoryImpl implements LottoFactory {

    private final int startInclusive;
    private final int endInclusive;
    private final int count;

    public LottoFactoryImpl(int startInclusive, int endInclusive, int count) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.count = count;
    }

    @Override
    public Lotto create() {
        List<Integer> lottoCombination = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
        return new Lotto(lottoCombination);
    }
}
