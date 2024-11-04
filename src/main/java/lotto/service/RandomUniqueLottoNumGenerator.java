package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomUniqueLottoNumGenerator implements LottoNumGenerator {
    @Override
    public List<Integer> generateNumbers(final int min, final int max, final int cnt) {
        return Randoms.pickUniqueNumbersInRange(min, max, cnt);
    }
}
