package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.policy.LottoPolicy;

public class LottoStore {

    public List<Lotto> purchase(int price) {
        int numOfLotto = price / LottoPolicy.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoPolicy.MIN_LOTTO_NUM, LottoPolicy.MAX_LOTTO_NUM, LottoPolicy.TOTAL_LOTTO_COUNT);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}
