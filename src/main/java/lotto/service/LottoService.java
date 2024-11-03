package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.RandomNumber;

public class LottoService {
    private static Integer DIVIDED_AMOUNT = 1000;

    public int getPurchaseCount(int purchaseAmount) {
        return purchaseAmount / DIVIDED_AMOUNT;
    }

    public List<Lotto> makeLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> randomNumbers = RandomNumber.make();
        return new Lotto(randomNumbers);
    }
}
