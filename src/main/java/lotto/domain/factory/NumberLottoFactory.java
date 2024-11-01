package lotto.domain.factory;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Component;
import lotto.domain.ComponentNumber;

import java.util.List;
import java.util.stream.Collectors;

public class NumberLottoFactory implements LottoFactory {

    private final int startInclusive;
    private final int endInclusive;
    private final int lottoLength;

    public NumberLottoFactory(int startInclusive, int endInclusive, int lottoLength) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.lottoLength = lottoLength;
    }


    @Override
    public List<Component> randomCreate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, lottoLength);
        return numbers.stream()
                .sorted()
                .map(ComponentNumber::new)
                .collect(Collectors.toList());
    }

}
