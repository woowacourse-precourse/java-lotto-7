package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoNumberGenerator {
    public List<Lotto> getLotto(long count) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotto.add(new Lotto(getRandomNumbers()));
        }
        return lotto;
    }

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
