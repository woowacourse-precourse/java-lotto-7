package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1_000;

    public static List<Lotto> purchaseLottos(int budget) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = budget / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
