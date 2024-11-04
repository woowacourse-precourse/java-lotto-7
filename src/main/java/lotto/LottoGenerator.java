package lotto;

import static lotto.LottoConstant.MAX_VALUE;
import static lotto.LottoConstant.MIN_VALUE;
import static lotto.LottoConstant.NUMBER_COUNT;
import static lotto.LottoConstant.PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> purchase(long purchaseAmount) {
        long lottoCount = purchaseAmount / PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> numbers = pickNumbers();
        return new Lotto(numbers);
    }

    private List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, NUMBER_COUNT);
    }
}
