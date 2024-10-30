package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

public class RandomUniqueLottoNumGenerator implements LottoNumGenerator {
    @Override
    public List<Integer> generateSortedNumbers(int min, int max, int cnt) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(min, max, cnt);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
