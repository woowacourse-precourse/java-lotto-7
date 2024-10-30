package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class SortedLottoNumberGenerator implements NumberGenerator<List<Integer>> {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    public static final int LOTTO_COUNT = 6;

    @Override
    public List<Integer> generate() {
        return sortAscending(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT));
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        return numbers;
    }
}
