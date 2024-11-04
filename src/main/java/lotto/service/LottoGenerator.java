package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottoGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_TOTAL_COUNT = 6;
    private static final int LOTTO_PRICE_UNIT = 1000;

    public Lotto generateLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_TOTAL_COUNT);
        return new Lotto(lotto);
    }

    public Lottos getnerateLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        int count = amount / LOTTO_PRICE_UNIT;
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }
}
