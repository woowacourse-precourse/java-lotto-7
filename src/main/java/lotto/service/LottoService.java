package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.RandomNumber;

public class LottoService {
    private static Integer DIVIDED_AMOUNT = 1000;

    public int getPurchaseCount(int purchaseAmount) {
        return purchaseAmount / DIVIDED_AMOUNT;
    }

    private Lotto createLotto() {
        List<Integer> randomNumbers = RandomNumber.make();
        return new Lotto(randomNumbers);
    }
}
