package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

public class RandomUniqueLottoNumGenerator implements LottoNumGenerator {
    @Override
    public List<Integer> generateSortedNumbers(int min, int max, int cnt) {
        return Randoms.pickUniqueNumbersInRange(min, max, cnt);
    }
}
