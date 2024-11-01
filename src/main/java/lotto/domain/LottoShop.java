package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoShop {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int RANDOM_NUMBER_COUNT = 6;

    public Lottos buyLottos(long amount) {
        List<Lotto> lottos = new ArrayList<>();
        while (amount-- > 0) {
            lottos.add(generateLotto());
        }

        return new Lottos(lottos);
    }

    private Lotto generateLotto() {
        List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, RANDOM_NUMBER_COUNT);
        return new Lotto(pickedNumbers);
    }
}
