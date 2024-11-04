package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> generateLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        int count = amount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}