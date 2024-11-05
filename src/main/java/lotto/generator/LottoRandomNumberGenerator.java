package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoRandomNumberGenerator implements RandomNumberGenerator {

    @Override
    public List<Integer> generate(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count)
            .stream()
            .sorted()
            .toList();
    }
}
