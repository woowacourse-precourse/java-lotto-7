package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.Limit;

import java.util.List;

public class LottoGenerator {
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Limit.LOTTO_MIN_NUMBER, Limit.LOTTO_MAX_NUMBER, Limit.LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .toList();
        return new Lotto(numbers);
    }
}