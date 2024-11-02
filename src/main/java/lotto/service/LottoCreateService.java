package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoCreateService {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_PRICE = 1000;

    public Lottos createLottosWithMoney(int money) {
        int lottoCount = money / LOTTO_PRICE;
        return createLottos(lottoCount);
    }

    public Lottos createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = createRandomNumbers();
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }

    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX,
            LOTTO_NUMBER_COUNT);
    }

}
