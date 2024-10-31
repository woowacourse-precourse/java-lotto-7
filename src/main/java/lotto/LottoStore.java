package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public List<Lotto> purchase(int price) {
        int numOfLotto = price / Lotto.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    Lotto.MIN_LOTTO_NUM, Lotto.MAX_LOTTO_NUM, Lotto.TOTAL_LOTTO_COUNT);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}
