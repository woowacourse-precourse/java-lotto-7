package lotto.generator;

import static lotto.config.LottoRule.LOTTO_COUNT;
import static lotto.config.LottoRule.LOTTO_END_NUMBER;
import static lotto.config.LottoRule.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class SortedLottoNumberGenerator implements NumberGenerator<List<Integer>> {


    @Override
    public List<Integer> generate() {
        return sortAscending(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT));
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        return numbers;
    }
}
