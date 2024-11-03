package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.domain.LottoRule.*;

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
