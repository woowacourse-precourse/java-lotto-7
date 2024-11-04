package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoNumberGenerator {
    public static List<Integer> generateNumbers() {
        List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream()
                .sorted()
                .toList();
    }
}
