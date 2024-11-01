package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final static int LOTTO_LENGTH = 6;
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;

    public static Lottos generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return new Lottos(lottos);
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_LENGTH);
    }
}
