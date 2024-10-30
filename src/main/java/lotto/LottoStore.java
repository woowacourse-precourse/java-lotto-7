package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int TOTAL_LOTTO_COUNT = 6;

    public List<Lotto> purchase(int price) {
        int numOfLotto = price / Lotto.PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, TOTAL_LOTTO_COUNT);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}
