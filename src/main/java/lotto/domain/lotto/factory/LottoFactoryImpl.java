package lotto.domain.lotto.factory;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEntry;
import lotto.domain.lotto.Number;

import java.util.List;
import java.util.stream.Collectors;

public class LottoFactoryImpl implements LottoFactory {

    private final int startInclusive;
    private final int endInclusive;
    private final int lottoLength;

    public LottoFactoryImpl(int startInclusive, int endInclusive, int lottoLength) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.lottoLength = lottoLength;
    }


    @Override
    public List<LottoEntry> create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, lottoLength);
        return numbers.stream()
                .sorted()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    @Override
    public int getLottoLength() {
        return lottoLength;
    }
}
