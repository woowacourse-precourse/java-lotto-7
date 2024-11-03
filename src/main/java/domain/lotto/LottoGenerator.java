package domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    public static Lotto generate() {
        List<LottoNumber> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}