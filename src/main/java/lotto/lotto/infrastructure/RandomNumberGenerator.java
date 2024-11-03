package lotto.lotto.infrastructure;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.service.NumberGenerator;

import java.util.List;

public class RandomNumberGenerate implements NumberGenerator {
    private final int MIN_LOTTO_NUMBER_RANGE = 1;
    private final int MAX_LOTTO_NUMBER_RANGE = 45;
    private final int NUMBER_COUNT = 6;
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER_RANGE, MAX_LOTTO_NUMBER_RANGE, NUMBER_COUNT);
    }
}
