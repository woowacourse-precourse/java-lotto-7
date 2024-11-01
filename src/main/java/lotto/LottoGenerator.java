package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> generate(int amount) {
        int count = amount / LOTTO_PRICE;
        return createLottos(count);
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(createLotto());
        }
        return lottoList;
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
