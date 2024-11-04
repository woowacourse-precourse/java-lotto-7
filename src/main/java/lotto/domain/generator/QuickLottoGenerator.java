package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.number.Lotto;

public class QuickLottoGenerator implements LottoGenerator {

    public Lotto generate(final int min, final int max, final int count) {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(min, max, count);
        return new Lotto(numbers);
    }

}
