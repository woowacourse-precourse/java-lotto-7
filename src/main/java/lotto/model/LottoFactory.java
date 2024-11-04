package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static Lottos generateLottos(Cost cost) {
        int lottoCount = calculateLottoCount(cost);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    private static int calculateLottoCount(Cost cost) {
        return cost.getValue() / LOTTO_PRICE;
    }
}
