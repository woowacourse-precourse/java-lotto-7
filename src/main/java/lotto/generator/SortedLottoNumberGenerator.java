package lotto.generator;

import static lotto.config.LottoRule.LOTTO_MAX_NUMBER;
import static lotto.config.LottoRule.LOTTO_MIN_NUMBER;
import static lotto.config.LottoRule.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class SortedLottoNumberGenerator implements NumberGenerator<List<Integer>> {

    @Override
    public List<Integer> generate() {
        return sortAscending(
                Randoms.pickUniqueNumbersInRange(
                        LOTTO_MIN_NUMBER.getValue(),
                        LOTTO_MAX_NUMBER.getValue(),
                        LOTTO_SIZE.getValue()
                )
        );
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }
}
