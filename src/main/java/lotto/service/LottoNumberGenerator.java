package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int GENERATED_NUMBERS = 6;

    public List<Integer> getLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, GENERATED_NUMBERS)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
